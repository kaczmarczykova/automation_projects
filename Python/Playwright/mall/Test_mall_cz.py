import pytest
import playwright.sync_api as pw
import mall_cz
import definitions

@pytest.mark.playwright
def test_hairdryers(page):
    page.goto(definitions.BASE_URL)
    mall_cz.accept_cookies(page)
    page.locator('[data-testid="desktop-menu__title"]').first.click()
    page.get_by_text('Fény', exact = True).click()
    page.wait_for_load_state("networkidle")

    mall_cz.close_advertisement(page)
    product_name = page.locator("span.bs__name").first.inner_text()
    print(product_name)
    page.get_by_test_id("bs-item").first.click()
    #page.locator('[data-sel="add-to-cart-button-main"]').click()
    page.get_by_test_id('rounded-button').first.click()
    mall_cz.go_to_cart(page)

    
    
    
    
    
    
    
    
    
