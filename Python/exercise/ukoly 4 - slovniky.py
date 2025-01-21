import random

# Napiš funkci, která pro argumentem zadané číslo n vytvoří a vrátí slovník, kde jako klíče budou čísla od jedné do n 
# a jako hodnoty k nim jejich druhé mocniny.

def slovnik_mocnin(n):
    mocniny = {}
    for i in range (1, n + 1):
        mocniny[i] = i ** 2
    print(mocniny)
    return mocniny

#slovnik = slovnik_mocnin(5)

##############################################################################

# Napiš funkci, která vrátí sumu všech klíčů a sumu všech hodnot ve slovníku, který dostane jako argument. 
# K vyzkoušení můžeš použít slovník z minulé úlohy.

def vypis_sumu(slovnik):
    suma_klic = 0
    suma_hodnota = 0
    for klic, hodnota in slovnik.items():
        suma_klic += klic
        suma_hodnota += hodnota
    print(suma_klic)
    print(suma_hodnota)
    return suma_klic, suma_hodnota

#vypis_sumu(slovnik)

##############################################################################

# Napiš funkci, která vypíše obsah slovníku (klíče a k nim náležící hodnoty) na jednotlivé řádky. Funkci, která něco vypisuje, 
# je vhodné pojmenovat speciálně, zde třeba vypis_slovnik, aby bylo jasné, že jen vypisuje a nic nevrací. 
# K vyzkoušení můžeš zase použít slovník z minulé úlohy.

def vypis_slovnik(slovnik):
    for klic, hodnota in slovnik.items():
        print(f'Klíč {klic}, hodnota {hodnota}')

#vypis_slovnik(slovnik)

##############################################################################

# Napiš funkci, která jako argument dostane řetězec a vrátí slovník, ve kterém budou jako klíče jednotlivé znaky 
# ze zadaného řetězce a jako hodnoty počty výskytů těchto znaků v řetězci.

def slovnik_znaku(retezec):
    slovnik = {}
    for i in range (len(retezec)):
        if retezec[i] not in slovnik:
            pocet = 0
            for j in range (len(retezec)):
                if retezec[j] == retezec[i]:
                    pocet += 1
            slovnik[retezec[i]] = pocet
    print(slovnik)
    return slovnik

#slovnik_znaku("hello world")

##############################################################################

# Vytvoř dva slovníky {'a': 1, 'b': 2} a {'c': 3, 'd':4} a sluč je dohromady. Kolik bude mít výsledný slovník položek? 
# Vytvoř dva slovníky {'a': 1, 'b': 2} a {'a': 3, 'd':4} a sluč je dohromady. Kolik bude mít výsledný slovník položek?

def sluc_slovniky(slovnik1, slovnik2):
    slouceny_slovnik = slovnik1
    for klic, hodnota in slovnik2.items():
        if klic not in slouceny_slovnik:
            slouceny_slovnik[klic] = hodnota
        else:
            slouceny_slovnik[klic] = [slovnik1[klic], slovnik2[klic]]
    print(slouceny_slovnik)
    return slouceny_slovnik

#sluc_slovniky({'a': 1, 'b': 2}, {'c': 3, 'd':4})
#sluc_slovniky({'a': 1, 'b': 2}, {'a': 3, 'd':4})

##############################################################################

# Úkolem je vytvořit známou skautskou hru „Kdo? S kým? Co dělali?“. Hra se hráče zeptá postupně na různé otázky, 
# například „Kdo?“, „S kým?“, „Co dělali?“, „Kde?“, „Kdy?“, a nakonec „Proč?“, s tím, že mu umožní na jednu otázku odpovědět 
# vícekrát a všechny odpovědi si uloží. Na závěr pak hra z každé sady odpovědí vybere náhodně jednu odpověď a z takto 
# vybraných odpovědí složí větu, kterou vypíše uživateli. Seznam otázek by mělo být možné změnit v kódu na jednom místě 
# bez zásahu do logiky programu.

def skauti():
    slovnik = {}
    otazky = ["Kdo?", "S kým?", "Co dělali?", "Kde?", "Kdy?", "Proč?"]
    for otazka in otazky:
        dalsi = True
        while dalsi == True:
            odpoved = input(otazka + ' ')
            if otazka not in slovnik:    
                slovnik[otazka] = [odpoved]
            elif otazka in slovnik and len(odpoved) > 0:
                slovnik[otazka].append(odpoved)
            elif odpoved.strip() == "":
                break    
    veta = ''
    for klic, hodnota in slovnik.items():
            slovo = random.choice(slovnik[klic])
            veta += (slovo + ' ')
    veta = veta[0].upper() + veta[1:] + '.'
    print(veta)
    return veta

#skauti()

##############################################################################

# U skautů ještě zůstaneme. Napiš program, který přeloží zadaný řetězec do morseovy abecedy, tečku nahraď slovem STOP, 
# ostatní interpunkci můžeš ignorovat, slova oddělujte svislítkem '|'.

mabeceda = {'0' : '-----',
            '1' : '.----',
            '2' : '..---',
            '3' : '...--',
            '4' : '....-',
            '5' : '.....',
            '6' : '-....',
            '7' : '--...',
            '8' : '---..',
            '9' : '----.',
            'A' : '.-'   ,
            'B' : '-...' ,
            'C' : '-.-.' ,
            'D' : '-..'  ,
            'E' : '.'    ,
            'F' : '..-.' ,
            'G' : '--.'  ,
            'H' : '...'  ,
            'I' : '..'   ,
            'J' : '.---' ,
            'K' : '-.-'  ,
            'L' : '.-..' ,
            'M' : '--'   ,
            'N' : '-.'   ,
            'O' : '---'  ,
            'P' : '.--.' ,
            'Q' : '--.-' ,
            'R' : '.-.'  ,
            'S' : '...'  ,
            'T' : '-'    ,
            'U' : '..-'  ,
            'V' : '...-' ,
            'W' : '.--'  ,
            'X' : '-..-' ,
            'Y' : '-.--' ,
            'Z' : '--..' }

def morseovka(text):
    prepis = ''
    for znak in text:
        if znak.upper() in mabeceda or znak.isdigit():
            prepis += mabeceda[znak.upper()]
        elif znak == ' ':
            prepis += '|'
        elif znak == '.':
            prepis += 'STOP'
    print(prepis)
    return prepis

#morseovka('Hello world.')