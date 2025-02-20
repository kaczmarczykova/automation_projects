# Udělej si seznam domácích zvířat. Budeš ho potřebovat v dalších úlohách. Domácí zvířata známe tato: "pes", "kočka", "králík", "had", můžeš přidat nějaké svoje oblíbené, 
# žádné ale neubírej. Napiš funkci, která přebere seznam a slovo a zjistí, jestli je to slovo v seznamu domácích zvířat.
# „Zjistí“ znamená, že funkce vrátí True nebo False.

def zjisti(slovo, seznam):
    for zvire in seznam:
        if zvire == slovo:
            return True

##############################################################################

# Napiš program, který na konec seznamu zvířat přidá zvíře zadané uživatelem, ale pozor jen, pokud tam ještě není. Upravený seznam program vypíše.

def pridej(slovo, seznam):
    if slovo not in seznam:
        seznam.append(slovo)
    print(seznam)

##############################################################################

# Napiš funkci, která dostane dva seznamy jmen domácích zvířat a vrátí tři seznamy:
# -zvířata, která jsou v obou seznamech (bez opakování, tedy sjednocení množin: první ∪ druhá),
# -zvířata, která jsou jen v prvním seznamu (bez opakování, tedy rozdíl množin: první - druhá),
# -zvířata, která jsou jen ve druhém seznamu (bez opakování, tedy rozdíl množin: druhá - první).

def dva_seznamy(seznam1, seznam2):
    sjednoceni = []
    rozdil1 = []
    rozdil2 = []

    # sjednoceni mnozin
    for i in range (len(seznam1)):
        sjednoceni.append(seznam1[i])
    for prvek in seznam2:
        if prvek not in sjednoceni:
            sjednoceni.append(prvek)

    # rozdil mnozin prvni - druha
    for prvek in seznam1:
        if prvek not in seznam2:
            rozdil1.append(prvek)
            
    # rozdil mnozin druha - prvni
    for prvek in seznam2:
        if prvek not in seznam1:
            rozdil2.append(prvek)

    print(sjednoceni)
    print(rozdil1)
    print(rozdil2)

#dva_seznamy(["pes", "kočka", "králík", "had"], ["pes", "koza", "vlk", "had"])

##############################################################################

# Napiš funkci, která ze seznamu jmen domácích zvířat (zadaný argumentem) vrátí ta, která jsou kratší než 5 písmen.

def kratke_zvire(seznam):
    for prvek in seznam:
        if len(prvek) < 5:
            print(prvek, end= ', ')

#kratke_zvire(["pes", "kočka", "králík", "had"])

##############################################################################

# Napiš funkci, která ze seznamu jmen domácích zvířat (zadaný argumentem) vrátí ta, která začínají na písmeno k.

def prvni_pismeno(seznam, pismeno):
    for prvek in seznam:
        if prvek[0] == pismeno.lower():
            print(prvek, end= ', ')

#prvni_pismeno(["pes", "kočka", "králík", "had"], 'k')

##############################################################################

# Napiš program, který seřadí seznam domácích zvířat podle abecedy.

def serad_seznam(seznam):
    seznam.sort()
    print(seznam)
    return seznam

#serad_seznam(["pes", "kočka", "králík", "had"])

##############################################################################

# Had byl pyšný na to, že je v abecedě první. Dokud nepřiletěla "andulka".Abys hada uklidnila, vytvoř funkci, která zvířata seřadí podle abecedy, 
# ale bude ignorovat první písmeno t.j. vrátí:
# "had",
# "pes",
# "andulka",
# "kočka",
# "králík".
# Postup: Máš seznam hodnot, které chceš seřadit podle nějakého klíče. Klíč se dá z každé hodnoty vypočítat. Vytvoř seznam dvojic (klíč, hodnota). 
# Seřaď tento seznam dvojic – dvojice se řadí nejdřív podle prvního prvku, pak druhého atd. Nakonec vytvoř ze seznamu dvojic opět jen seznam hodnot.

def priletela_andulka(seznam):
    klic = []
    for zvire in seznam:
        dvojice = []
        dvojice.append(zvire[1:])
        dvojice.append(zvire)
        klic.append(dvojice)
    klic.sort()
    for dvojice in klic:
        print(dvojice[1], end= ', ')
    return klic

#priletela_andulka(["pes", "kočka", "králík", "had", "andulka"])

##############################################################################

# Napiš funkci, která převede římské číslice zadané jako řetězec str na číslo int.

def rimske_cislice(cislo):
    arabsky = 0
    rimske = cislo
    cislo = " " + cislo

    while len(cislo) > 1:
        if cislo[-1].lower() == 'i':
            if cislo[-2].lower() == 'i':
                if cislo[-3].lower() == 'i':
                    arabsky +=3
                    cislo = cislo[:-3]
                else:
                    arabsky += 2
                    cislo = cislo[:-2]
            else:
                arabsky += 1
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'v':
            if cislo[-2].lower() == 'i':
                arabsky += 4
                cislo = cislo[:-2]
            else:
                arabsky += 5
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'x':
            divne_cislo = cislo[-2].lower()
            if cislo[-2].lower() == 'i':
                arabsky += 9
                cislo = cislo[:-2]
            else:
                arabsky += 10
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'l':
            if cislo[-2].lower() == 'x':
                arabsky += 40
                cislo = cislo[:-2]
            else:
                arabsky += 50
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'c':
            if cislo[-2].lower() == 'x':
                arabsky += 90
                cislo = cislo[:-2]
            else:
                arabsky += 100
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'd':
            if cislo[-2].lower() == 'c':
                arabsky += 400
                cislo = cislo[:-2]
            else:
                arabsky += 500
                cislo = cislo[:-1]
        if cislo[-1].lower() == 'm':
            if cislo[-2].lower() == 'c':
                arabsky += 900
                cislo = cislo[:-2]
            else:
                arabsky += 1000
                cislo = cislo[:-1]
    print(rimske + " " + str(arabsky))
    return arabsky

"""success = True
if (rimske_cislice('MCMXCIX') != 1999): success = False
if (rimske_cislice('MCMXIX') != 1919): success = False
if (rimske_cislice('MCMXCIV') != 1994): success = False
if (rimske_cislice('MCDLXXVI') != 1476): success = False
if (rimske_cislice('DCCCIV') != 804): success = False
print(success)"""

##############################################################################

# Napište program, který vyřeší následující úlohu: Na dlouhé chodbě je 100 dveří, všechny jsou na začátku zavřené. 
# Při prvním průchodu otočíme (tzn. zavřeme pokud byly otevřené/otevřeme pokud byly zavřené) všechny dveře, 
# při druhém průchodu otočíme pouze každé druhé dveře, při třetím průchodu každé třetí atd. až do 100 průchodů, 
# kdy otočíme pouze poslední dveře. Které dveře zůstanou na konci otevřené? Vypište jejich pořadová čísla.

def dvere(pocet_dveri):
    chodba = []
    for i in range (pocet_dveri):
        chodba.append(False)
    for i in range(pocet_dveri):
        for j in range(0, pocet_dveri, i):
            chodba[j] = not(chodba[j])
    return chodba

#dvere(100)

##############################################################################

# Napiš funkci, která dostane seznam souřadnic (párů čísel menších než 10, která určují sloupec a řádek) 
# a vypíše je jako mapu: mřížku 10×10, kde na políčka která jsou v seznamu napíše X, jinde tečku.

def vytvor_mrizku(vyska, sirka, body):
    mrizka = []
    for i in range (vyska):
        radek = []
        for j in range (sirka):
            radek.append('.')
        mrizka.append(radek)
    
    for bod in body:
        mrizka[bod[0]][bod[1]] = 'X'

    for radek in mrizka:
        for prvek in radek:
            print(prvek, end= '')
        print()
    return mrizka

#vytvor_mrizku(10, 10, [(0, 0), (0, 1), (2, 3), (3, 5), (9, 8)])

##############################################################################

# Napiš funkci pohyb, která dostane seznam souřadnic a světovou stranu ("s", "j", "v" nebo "z") a přidá k seznamu poslední 
# bod „posunutý“ v daném směru.

def pohyb(souradnice, strana):
    seznam_souradnic = [(0, 0)]

    if strana.lower() == 's':
        if (souradnice[0] - 1) >= 0:
            nova_souradnice = (souradnice[0] - 1, souradnice[1])
    elif strana.lower() == 'j':
        if (souradnice[0] + 1) <= sirka:
            nova_souradnice = (souradnice[0] + 1, souradnice[1])
    elif strana.lower() == 'v':
        if (souradnice[1] + 1) <= sirka:
            nova_souradnice = (souradnice[0], souradnice[1] + 1)
    elif strana.lower() == 'z':
        if (souradnice[1] - 1) >= 0:
            nova_souradnice = (souradnice[0], souradnice[1] - 1)

    seznam_souradnic.append(nova_souradnice)
    print(seznam_souradnic)

pohyb((2, 2), 's')
    
##############################################################################


# Napiš cyklus, který se bude ptát uživatele na světovou stranu, podle ní zavolá pohyb, a následně vykreslí seznam jako mapu. 
# Pak se opět se zeptá na stranu atd. Začínej se seznamem [(0, 0), (1, 0), (2, 0)]. 
# Doplň funkci pohyb tak, aby při pohybu umazala první bod ze seznamu souřadnic. Výsledný seznam tak bude mít stejnou délku, 
# jako před voláním.

def kam(souradnice, mrizka):
    while True:
        strana = input('Kterym smerem? ')
        moznosti = ['s', 'j', 'v', 'z']
        if strana.lower() in moznosti:
            pohyb(souradnice, strana)
            for radek in mrizka:
                for prvek in radek:
                    print(prvek, end= '')
                print()
            