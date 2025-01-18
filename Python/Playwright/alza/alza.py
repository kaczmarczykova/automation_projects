import definitions
import time

def accept_cookies(page):
    page.get_by_text('Rozumím', exact = True).click()

def find_TVs(page):
    #TVs = page.get_by_text('TV, foto, audio-video', exact = True)
    TVs = page.locator('[href="/tv-foto-audio-video"]')
    TVs.click()
    page.get_by_test_id('category-tile').nth(2).click()

def find_cheapest(page):
    #cheapest = page.locator('[id="hlNejlevnejsiSeo"]')
    #cheapest = page.locator(['[id="ui-id-3"]'])
    cheapest = page.locator('[href="/levne-televize/18849604.htm"]')
    cheapest.click()

def select_TV_in_stock(page):
    item = page.locator('[class="box.browsingitem.js-box.canBuy.inStockAvailability"]')
    i = 0
    
    while item.nth(i):
        target_text = "Skladem > 5"
        element_text = page.locator('span.avlVal.avl0.none').nth(i).text_content().strip()
        if target_text in element_text:
            simple_price = page.locator('[class="price-box__price"]').nth(i).text_content()
            page.locator('[class="btnk1"]').nth(i).click()
            break
        else:
            i += 1
    return simple_price

def get_expected_price(page, string):
    price = ''
    for i in range (len(string)):
        if string[i].isdigit():
            price += string[i]
    return int(price)

def go_to_cart(page):
    page.get_by_test_id("headerBasketIcon").click()

def increase_count(page, number):
    for i in range (1, number):
        page.locator('[class="countPlus"]').click()

def get_actual_price(page):
    value = page.locator('[class="last price"]').text_content()
    actual_price = ''
    for i in range (len(value)):
        if value[i].isdigit():
            actual_price += value[i]
    return int(actual_price)

def clear_cart(page):
    page.locator('[class="item-options__trigger"]').click()
    page.get_by_text("Odstranit", exact = True).click()
