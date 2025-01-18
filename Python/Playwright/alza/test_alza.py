import pytest
import playwright.sync_api as pw
import alza
import definitions

@pytest.mark.playwright
def test_cheapest_TVs(page):
    page.goto(definitions.BASE_URL)
    alza.accept_cookies(page)
    alza.find_TVs(page)
    alza.find_cheapest(page)   #nedari se mi seradit je podle ceny, proto dalsi test...


def test_cheapest_shortly(page):
    page.goto(definitions.CHEAPEST_TV_URL)
    alza.accept_cookies(page)
    string = alza.select_TV_in_stock(page)
    price = alza.get_expected_price(page, string)
    alza.go_to_cart(page)
    alza.increase_count(page, 2)
    actual_prize = alza.get_actual_price(page)
    assert price * 2 == actual_prize
    alza.clear_cart(page)   #tak jeste vyprazdnit kosik se mi nedari


  