import pytest
import playwright.sync_api as pw
import re
import definitions
import meta

@pytest.mark.playwright
def test_1_login_functionality(page):

    # 1. Login with Valid Credentials
    meta.login(page, definitions.ENTITY_CREDS)
    #page.evaluate("document.body.style.zoom = '0.33'")
    pw.expect(page).to_have_url(definitions.HOME_URL)
    meta.logout(page)

    # 2. Login with Invalid Credentials
    meta.login(page, definitions.TESTING_CREDS_INVALID)
    assert page.get_by_text("Invalid credentials. Please try again.", exact = True).is_visible()
    meta.logout(page)

    # 3. Login with Missing Credentials
    meta.login(page, definitions.TESTING_CREDS_INCOMPLETE)
    meta.getValidationMessage()
    assert page.get_by_text("Vyplňte prosím toto pole.", exact = True).is_visible()
    meta.logout()

    # 4.  Login with Valid Credentials API




def test_2_form_submission(page):

    # 1. Submit Form with Missing Data
    meta.login(page, definitions.ENTITY_CREDS)
    #page.evaluate("document.body.style.zoom = '0.33'")
    meta.open_form(page)
    meta.fill_form_and_submit(page, definitions.FORM_DATA_INCOMPLETE)
    pw.expect(page).to_have_text(re.compile("Vyplňte prosím toto pole.", re.IGNORECASE))

def test_2_1_form_submission(page):
    # 2. Submit Form with Valid Data
    meta.login(page, definitions.ENTITY_CREDS)
    page.evaluate("document.body.style.zoom = '0.33'")
    meta.open_form(page)
    #page.reload()
    meta.fill_form_and_submit(page, definitions.FORM_DATA)
    saved_data = page.get_by_text("saved-item")
    # check Name is saved correctly
    pw.expect(saved_data).to_contain_text(definitions.FORM_DATA[0])
    # check Email is saved correctly
    pw.expect(saved_data).to_contain_text(definitions.FORM_DATA[1])
    # check Message is saved correctly
    pw.expect(saved_data).to_contain_text(definitions.FORM_DATA[2])