import random

# Napiš funkci, která vrátí obvod čtverce, kdy délka strany čtverce je zadána parametrem funkce. 
# Výsledek funkce vypiš v těle hlavního programu pomocí print. (Tzn. tělo funkce nebude obsahovat print)

def obvod_ctverce(strana):
    return 4 * strana
    
#print(obvod_ctverce(5))

##############################################################################

# Napiš funkci, která vypíše do jednoho řádku prvních 11 násobků zvoleného čísla (argument funkce). 
# Např.: pro vstup 2 vypíše funkce 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20.

def nasobky_cisla(cislo):
    for i in range(11):
        print(cislo * i, end=' ')

#nasobky_cisla(2)

##############################################################################

# Změn funkci z předchozího úkolu tak, aby funkce měla tři argumenty – číslo, počet vypisovaných násobků, 
# znak pro oddělení vypsaných násobků.

def nasobky_cisla_2(cislo, pocet, znak):
    for i in range(pocet):
        print(cislo * i, end=znak)

#nasobky_cisla_2(2, 11, ' ')

##############################################################################

# Napiš funkci, která rozhodne jestli zadané číslo je liché.

def liche_cislo(cislo):
    if cislo % 2 == 1:
        return True
    
#liche_cislo(8)

##############################################################################

# Napiš funkci, která pro zadaný počet N vygeneruje N náhodných čísel, každé vygenerované číslo vypíše spolu s informací, 
# zda-li je liché či nikoliv. Tuto funkci si pojmenuj jednoduše lichost_nahodnych_cisel(pocet).

def lichost_nahodnych_cisel(pocet):
    for i in range (pocet):
        cislo = random.randrange(0,1000)
        liche_cislo(cislo)
        if liche_cislo(cislo):
            print(cislo, 'Cislo je liche.')
        else:
            print(cislo, 'Cislo je sude.')

#lichost_nahodnych_cisel(5)

##############################################################################

# Napiš program, který simuluje tuto hru: První hráč hází kostkou (t.j. vybírají se náhodná čísla od 1 do 6), dokud nepadne šestka. 
# Potom hází další hráč, dokud nepadne šestka i jemu. Potom hází hráč třetí a nakonec čtvrtý. 
# Vyhrává ten, kdo na hození šestky potřeboval nejvíc hodů. (V případě shody vyhraje ten, kdo házel dřív.) 
# Program by měl vypisovat všechny hody a nakonec napsat, kdo vyhrál.

def hod_kostkou():
    pocet_hodu = 0
    vitez = 0
    for i in range (1,5):
        pocet_hodu_i = 0
        while True:
            hod = random.randrange(1,7)
            if hod != 6:
                pocet_hodu_i += 1
            else:
                break
        if pocet_hodu_i > pocet_hodu:
            pocet_hodu = pocet_hodu_i
            vitez = i
                
    print('Vitezem je hrac cislo ', vitez)

#hod_kostkou()

##############################################################################

# Napiš program, který se zeptá na příjmení uživatelky/uživatele a zkusí podle něj uhodnout její/jeho pohlaví.

def hadej_pohlavi():
    jmeno = input('Zadej sve prijmeni: ')
    if jmeno[-1] == 'á':
        print('Jsi zena')
    else:
        print('Jsi muz')

#hadej_pohlavi()

##############################################################################

# Najdi na internetu text své oblíbené písně, zkopíruj si ho do řetězce a zjisti, kolikrát je v něm použito písmeno K.

def spocitej_k(text):
    count = 0
    for i in range(len(text)):
        if text[i].lower() == 'k':
            count += 1
    print(count)

lyrics = '''Mlčíš a svět je funny záhadou
stává se pro mě "hany", když dračí drápy tnou
Temnice tmavá vříská bleskne tmou,
mý vlasy loučí víská a letí nad vodou.
A hrubý síly vzývám snídám bezpráví,
tvý voči v hlavě vídám,
je to všechno jedna velká síla.
Jestli se vážně hodíš, nevím, nejdu spát,
na kolej kluky vodíš a ráno se chceš brát.
Jestli se ke mně hodíš snad jdu k tobě spát.
S láskou se vůní brodíme.
Postelový království za koně nechce se mi dát,
jsem na tom stejně, mám tě rád.
Jablkem, jablkem nejsi,
kousnu hloubš a zlíbám tě celou.
Mersi jó mersi tak opustit zoufalců ráj,
chci zas v tobě spát.
Říkáš, že svět je krásnej, svět je zlej,
až naše hvězda zhasne haudy haudy héééj.
Štěstím se lůza brodí, neříkám,
hledá a pravdu rodí neví nesvlíká
tě lásko
A hrubý síly vzývám snídám bezpráví,
tvý voči v hlavě vídám je to všechno jedna velká síla.
Jestli se vážně hodíš nevím nejdu spát,
na kolej kluky vodíš a ráno se chceš brát.
Jestli se ke mně hodíš snad jdu k tobě spát.
S láskou se vůní brodíme.
Postelový království za koně nechce se mi dát,
jsem na tom stejně mám tě rád.
Jablkem jablkem nejsi,
kousnu hloubš a zlíbám tě celou.
Mersi jó mersi tak opustit zoufalců ráj,
chci zas v tobě spát.
Sami se k břehům kloníme sami jak bezvládnej proud.
Sami se proti vlnám stavíme sami se chcem zbavit těch pout.
Sami se k břehům kloníme sami jak bezvládnej proud jéé .
Sami se proti vlnám stavíme.
Jsem na tom stejně mám tě rád,
jsem na tom stejně mám tě rád.
jablkem jablkem nejsi
kousnu hloubš a zlíbám tě celou
mersi jó mersi tak opustit zoufalců ráj
chci zas v tobě spát...'''

#spocitej_k(lyrics)

##############################################################################

# Napiš funkci, která vrátí počet znaků (bez mezer) v řetězci, který je zadaný jako argument funkce. Výsledek funkce vypiš v těle hlavního programu pomocí print.

def pocet_znaku(text):
    count = 0
    for i in range(len(text)):
        if text[i] != ' ':
            count += 1
    return count

#print(pocet_znaku('Ema mele maso. '))

##############################################################################

# Napiš funkci, která v zadaném řetězci zamění první písmeno za velké. Obdobně můžeš zkusit jiné záměny, např. poslední písmeno, třetí písmeno, atd.

def vymen_pismeno(text):
    print(text[0].upper() + text[1:])
    
#vymen_pismeno('male pismeno zmenim na velke')

##############################################################################

# Napiš program, který vypíše obsah souboru prvni.txt na obrazovku.

def vypis_text_ze_souboru(text):
    with open (text, encoding = 'utf-8') as soubor:
        for radek in soubor:
            radek = radek.rstrip()
            print(radek)

#vypis_text_ze_souboru('d:\Dokumenty mamka\Python\Cvičení\prvni.txt')

##############################################################################

# Napiš program, který ze souboru prvni.txt určí: počet řádků v souboru, počet znaků v souboru. Tyto hodnoty zapiš do nového souboru. 
# Při počítání znaků v souboru nezapoměň vynechat tzv. bílé znaky, abys dostala správný počet písmen, číslic a případně speciálních znaků, které jsou v souboru. 
# Ujisti se také, že jsi správně spočítala počet řádků (že např. výsledný počet není o 1 menší než skutečný počet řádků v souboru).

def vypis_text_ze_souboru_2(text1, text2):
    with open (text1, encoding = 'utf-8') as soubor1:
        pocet_radku = 0
        pocet_znaku = 0
        for radek in soubor1:
            radek = radek.strip()
            pocet_radku += 1
            pocet_znaku += len(radek)

    with open (text2, mode='w', encoding = 'utf-8') as soubor2:
        print(pocet_radku, file = soubor2)
        print(pocet_znaku, file = soubor2)
              
#vypis_text_ze_souboru_2('d:\Dokumenty mamka\Python\Cvičení\prvni.txt', 'd:\Dokumenty mamka\Python\Cvičení\soubor_pro_zapis.txt')

##############################################################################

# Nakonec souboru prvni.txt přidej obsah souboru druhy.txt.

def vypis_text_ze_souboru_2(text1, text2):
    pisen = ''
    with open (text1, encoding = 'utf-8') as soubor1:        
        for radek in soubor1:
            pisen += radek
    with open (text2, encoding = 'utf-8') as soubor2:        
        for radek in soubor2:
            pisen += radek
    with open (text1, mode='w', encoding = 'utf-8') as soubor1:
        print(pisen, file = soubor1)

#vypis_text_ze_souboru_2('d:\Dokumenty mamka\Python\Cvičení\prvni.txt', 'd:\Dokumenty mamka\Python\Cvičení\druhy.txt')

##############################################################################

# Napiš funkci vyhodnot, která dostane řetězec s herním polem 1-D piškvorek a vrátí jednoznakový řetězec podle stavu hry:
# "x" – Vyhrál hráč s křížky (pole obsahuje "xxx")
# "o" – Vyhrál hráč s kolečky (pole obsahuje "ooo")
# "!" – Remíza (pole neobsahuje "-", a nikdo nevyhrál)
# "-" – Ani jedna ze situací výše (t.j. hra ještě neskončila)

def vyhodnot(pole):
    if 'xxx' in pole:
        print('Vitezi hrac s krizky!')
        return True
    elif 'ooo' in pole:
        print('Vitezi hrac s kolecky!')
        return True
    elif '-' not in pole:
        print('Remiza!')
        return True

##############################################################################

# Napiš funkci tah, která dostane řetězec s herním polem, číslo políčka (0-19), a symbol (x nebo o) a vrátí herní pole (t.j. řetězec) s daným symbolem umístěným na danou pozici.

def tah(pole, cislo_policka, symbol):
    "Vrátí herní pole s daným symbolem umístěným na danou pozici"
    pole_zleva = pole[:(cislo_policka)]
    pole_zprava = pole[(cislo_policka + 1):]
    pole = pole_zleva + symbol + pole_zprava
    print(pole)
    return pole

##############################################################################

# Napiš funkci tah_hrace, která dostane řetězec s herním polem, zeptá se hráče, na kterou pozici chce hrát, a vrátí herní pole se zaznamenaným tahem hráče. 
# Funkce by měla odmítnout záporná nebo příliš velká čísla a tahy na obsazená políčka. Pokud uživatel zadá špatný vstup, funkce mu vynadá a zeptá se znova.

def tah_hrace(pole):    
    while True:
        cislo_policka = int(input('Kam das svou znacku? ')) - 1
        if (0 <= cislo_policka <= 19) and pole[cislo_policka] == '-':
            pole = tah(pole, cislo_policka, 'x')
            break
        else:
            print('Zkus to znovu, tady to nepujde.')
    return pole

##############################################################################

# Napiš funkci tah_pocitace, která dostane řetězec s herním polem, vybere pozici, na kterou hrát, a vrátí herní pole se zaznamenaným tahem počítače. 
# Použij jednoduchou náhodnou „strategii”:
# 1.Vyber číslo od 0 do 19.
# 2.Pokud je dané políčko volné, hrej na něj.
# 3.Pokud ne, opakuj od bodu 1.

def tah_pocitace(pole):
    "Vrátí herní pole se zaznamenaným tahem počítače"
    while True:
        cislo_policka = random.randint(1, 20)
        if pole[cislo_policka] != 'x' and pole[cislo_policka] != 'o':
            pole = tah(pole, cislo_policka, 'o')
            break 
    return pole

##############################################################################

# Zvládneš pro počítač naprogramovat lepší strategii? Třeba aby se snažil hrát vedle svých existujících symbolů nebo aby bránil protihráčovi?

def tah_pocitace_strateg(pole):
    while True:
        pomocna_promenna = 0

        vyskyt = pole.find('x-x')
        if vyskyt > -1:
            #Neco
            print("Vyskyt")
            muj_tah = vyskyt + 1


        if ('x-x' in pole) or ('xx' in pole) or ('o-o' in pole) or ('oo' in pole):
            for i in range (len(pole)):
                print(i)
                # ('x-x' in pole)
                if pole[i] == 'x' and pole[i + 2] =='x' and (i + 2) < len(pole):
                    cislo_policka = i + 1
                    pomocna_promenna = 1
                    pass                    
                
                # ('xx' in pole)
                elif pole[i] == 'x' and pole[i + 1] == 'x' and (i + 2) < len(pole):
                    if pole[i + 2] == '-':
                        cislo_policka = i + 2
                        pomocna_promenna = 1
                        pass
                    elif pole[i - 1] == '-':
                        cislo_policka = i - 1
                        pomocna_promenna = 1
                        pass
                
                # ('o-o' in pole)
                elif pole[i] == 'o' and pole[i + 2] =='o' and (i + 2) < len(pole):
                    cislo_policka = i + 1
                    pomocna_promenna = 1
                    pass 
                
                # ('oo' in pole)
                elif pole[i] == 'o' and pole[i + 1] == 'o' and (i + 2) < len(pole):
                    if pole[i + 2] == '-':
                        cislo_policka = i + 2
                        pomocna_promenna = 1
                        pass
                    elif pole[i - 1] == '-':
                        cislo_policka = i - 1
                        pomocna_promenna = 1
                        pass          
        if pomocna_promenna == 0:
                cislo_policka = random.randint(0,20)  
        if pole[cislo_policka] != 'x' and pole[cislo_policka] != 'o':
            pole = tah(pole, cislo_policka, 'o')
            break 
    return pole

##############################################################################

# Napiš funkci piskvorky1d, která vytvoří řetězec s herním polem a střídavě volá funkce tah_hrace a tah_pocitace, dokud někdo nevyhraje nebo nedojde k remíze.

def piskvorky1d():
    pole = 20 * '-'
    print(pole)
    while vyhodnot(pole) != True:
        pole = tah_hrace(pole)
        vyhodnot(pole)
        pole = tah_pocitace_strateg(pole)
        vyhodnot(pole)

piskvorky1d()

##############################################################################

