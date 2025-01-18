import pytest
import playwright
import definitions

def go_to_homepage(page):
    page.goto(definitions.BASE_URL)

def accept_cookies(page):
    page.get_by_text('Souhlasím', exact = True).click()

def close_advertisement(page):
    '''advert = page.locator('[class="l-exponea-close"]').first.click()
    page.locator('[id="l-exponea-banner-backdrop"]').click()
    if advert.is_visible == True:
        advert.click()
        page.locator('[id="l-exponea-banner-backdrop"]').click()
    else:
        pass'''
    popup_selector = "#l-exponea-popup-banner"
    close_button_selector = "#l-exponea-close"
    if page.locator(popup_selector).is_visible():
        print("Popup found. Attempting to close it.")
        page.locator(close_button_selector).click()
        print("Popup closed.")
    else:
        pass

def go_to_cart(page):
    page.locator('[data-sel="nav-widget-cart-link"]').click()