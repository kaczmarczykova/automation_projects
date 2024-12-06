import pytest
import playwright.sync_api
import re
import datetime
import definitions

def login(page, creds):
    page.goto(definitions.BASE_URL)
    page.locator('[placeholder="Username"]').fill(creds[0])
    page.locator('[placeholder="Password"]').fill(creds[1])
    page.locator('[data-cy="login-button"]').click()

def logout(page):
    page.goto(definitions.HOME_URL)
    page.locator('button:has-text("Logout")').first.click()

def open_form(page):
    page.get_by_text("Go to Form Page", exact = True).click()
    
def fill_form_and_submit(page, name, email, message):
    page.locator('[id="name"]').fill(name)
    page.locator('[id="email"]').fill(email)
    page.locator('[id="message"]').fill(message)
    page.get_by_text("Save Information", exact = True)
