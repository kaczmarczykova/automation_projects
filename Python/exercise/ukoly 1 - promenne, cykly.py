import random

# Napiš program, který spočítá povrch a objem krychle o straně 2852 cm.

def geometricke_funkce(strana):
    povrch = 6 * strana**2
    objem = strana**3
    print('S = ', povrch, ', V = ', objem)

# geometricke_funkce(2852)

##############################################################################

# Změň program pro výpočet povrchu a objemu krychle tak, aby stranu/poloměr mohl uživatel zadat.

def geometricke_funkce_2():
    strana = int(input('Zadej delku strany: '))
    povrch = 6 * strana**2
    objem = strana**3
    print('S = ', povrch, ', V = ', objem)

# geometricke_funkce_2()

##############################################################################

# Napiš program, který postupně načte od uživatele dvě čísla a jednoznakový řetězec – buď '+', '-', '*' nebo '/'. 
# Program provede na číslech příslušnou operaci.

def nacti_cisla_a_proved_operaci():
    cislo1 = int(input('Zadej prvni cislo: '))
    cislo2 = int(input('Zadej druhe cislo: '))
    operace = input('Zadej druh operace: ')
    if operace == '+':
        print(f'{cislo1} + {cislo2} = ', cislo1 + cislo2)
    elif operace == '-':
        print(f'{cislo1} - {cislo2} = ', cislo1 - cislo2)
    elif operace == '*':
        print(f'{cislo1} * {cislo2} = ', cislo1 * cislo2)
    elif operace == '/' and cislo2 !=0:
        print(f'{cislo1} / {cislo2} = ', cislo1 / cislo2)
    else:
        print("Spatne zadani!)")

# nacti_cisla_a_proved_operaci()

##############################################################################

# kamen, nuzky, papir

def hra():
    body_hrac = 0
    body_PC = 0
    while body_hrac < 3 and body_PC < 3:
        hrac = input('Co zahrajes? Staci zadat k, n nebo p. ')
        PC = random.choice(['k', 'n', 'p'])
        
        if hrac == PC:
            print('Pocitac zahral ', PC)
            print('Nerozhodne!')
            print('Tvoje skore je ', body_hrac, ', pocitac ziskal ', body_PC, '.' )
        elif (hrac == 'k' and PC == 'n') or (hrac == 'n' and PC == 'p') or (hrac == 'p' and PC == 'k'):
            body_hrac += 1
            print('Pocitac zahral ', PC)
            print('Hrac ziskava bod!')
            print('Tvoje skore je ', body_hrac, ', pocitac ziskal ', body_PC, '.' )
        elif (hrac == 'n' and PC == 'k') or (hrac == 'p' and PC == 'n') or (hrac == 'k' and PC == 'p'):
            body_PC += 1
            print('Pocitac zahral ', PC)
            print('Pocitac ziskava bod!')
            print('Tvoje skore je ', body_hrac, ', pocitac ziskal ', body_PC, '.' )
    if body_hrac == 3:
        print('Gratuluji, zvitezil jsi!')
    elif body_PC == 3:
        print('Nevadi, priste to vyjde')
    

#hra()

#dalsikamen
def hrakakamen():
    body_hrac = 0
    body_PC = 0
    while body_hrac < 3 and body_PC < 3:
        hrac = input('Co zahrajes? Staci zadat k, n nebo p. ')
        PC = random.choice(['k', 'n', 'p'])
        
        if hrac == PC:
            vypis_skore(PC, body_hrac, body_PC)
            print('Nerozhodne!')

        elif (hrac == 'k' and PC == 'n') or (hrac == 'n' and PC == 'p') or (hrac == 'p' and PC == 'k'):
            body_hrac += 1
            vypis_skore(PC, body_hrac, body_PC)
            print('Hrac ziskava bod!')

        elif (hrac == 'n' and PC == 'k') or (hrac == 'p' and PC == 'n') or (hrac == 'k' and PC == 'p'):
            body_PC += 1
            vypis_skore(PC, body_hrac, body_PC)
            print('Pocitac ziskava bod!')

        else:
            print('Neplatne zadani')
            
    if body_hrac == 3:
        print('Gratuluji, zvitezil jsi!')
    else:
        print('Nevadi, priste to vyjde')
    
def vypis_skore(PC, body_hrac, body_PC):
    print('Pocitac zahral ', PC)
    print('Tvoje skore je ', body_hrac, ', pocitac ziskal ', body_PC, '.' )
##############################################################################

# Pomocí cyklu for napiš program, který vypíše:
# Řádek 0 
# Řádek 1
# Řádek 2
# Řádek 3
# Řádek 4

def printing_function():
    for i in range (0, 5):
        print('Řádek', i, sep= ' ')

#printing_function()

##############################################################################

# Pomocí cyklu for napiš program, který vypíše:
# 0 na druhou je 0
# 1 na druhou je 1
# 2 na druhou je 4
# 3 na druhou je 9
# 4 na druhou je 16

def printing_function_2():
    for i in range (0, 5):
        print(i, 'na druhou je', i**2, sep= ' ')

#printing_function_2()

##############################################################################

# Pomocí cyklu for a funkce range() napiš program, který vypíše:
# a
# a
# a
# a

def printing_function_3():
    for i in range (4):
        print('a')

#printing_function_3()

##############################################################################

# Napiš program, který postupně z jednotlivých 'X' vypíše:
# X
# X X
# X X X
# X X X X
# První řádek nesmí být prázdný.

def printing_function_4():
    for i in range (1,5):
        text = 'X '
        print(text * i)

#printing_function_4()

##############################################################################

# Pomocí cyklu for a příkazu if napiš program, který vypíše následující řádky. Funkci print volej pouze uvnitř v cyklu:
# první řádek
# není první
# není první
# není první

def printing_function_5():
    for i in range (1,5):
        if i ==1:
            print('první řádek')
        else:
            print('není první')

#printing_function_5()

##############################################################################

# Uhodni číslo. Pomocí cyklu while napiš program, který si vygeneruje náhodné číslo a bude se tě ptát na tvůj tip dokud ho neuhodneš. 
# Po tvém tipu ti dá nápovědu, jestli je tvůj tip větší, nebo menší než hádané číslo. 
# Pokud ho uhodneš, program skončí a napíše: "Uhodla jsi!".

def nahodny_tip():
    cislo = random.randrange(0,101)
    while True:
        tip = int(input('Zadej svuj tip: '))
        if tip > cislo:
            print('Tvuj tip je moc vysoky.')
        elif tip < cislo:
            print('Tvuj tip je moc nizky.')
        elif tip == cislo:
            print('Trefa!')
            break

#nahodny_tip()

##############################################################################

# Předchozí program doplň o počítadlo pokusů.

def nahodny_tip_2():
    cislo = random.randrange(0,101)
    pocitadlo = 0
    while True:
        tip = int(input('Zadej svuj tip: '))
        pocitadlo += 1
        if tip > cislo:
            print('Tvuj tip je moc vysoky.')
            print('Pokus cislo' , pocitadlo)
        elif tip < cislo:
            print('Tvuj tip je moc nizky.')
            print('Pokus cislo' , pocitadlo)
        elif tip == cislo:
            print('Trefa!')
            break

#nahodny_tip_2()

##############################################################################

# Napiš program, který se desetkrát zeptá na číslo a nejmenší zadané číslo vypíše.
# V tomto případě známe počet opakování, použij tedy cyklus for.

def print_lowest():
    for i in range (0, 10):
        cislo = int(input('Zadej cislo: '))
        if i == 0:
            lowest = cislo
        elif i!=0 and cislo < lowest:
            lowest = cislo
    print('Nejmensi zadane cislo je', lowest)
    
#print_lowest()

##############################################################################

# Pomocí dvou cyklů for a parametru end pro print napiš program, který vypíše následující tvar:
# X X X X X
# X X X X X
# X X X X X
# X X X X X
# X X X X X

def print_shape():
    for i in range (5):
        for j in range (5):
            print('X ', end= '')
        print()

#print_shape()

##############################################################################

# Pomocí dvou cyklů for a parametru end pro print napiš program, který vypíše „tabulku“ s násobilkou.
# 0 0 0 0 0
# 0 1 2 3 4
# 0 2 4 6 8
# 0 3 6 9 12
# 0 4 8 12 16

def calculator():
    for i in range (5):
        for j in range (5):
            print(i * j, ' ', end= '')
        print()

#calculator()

##############################################################################

# Pomocí dvou cyklů for a příkazu if napiš program, který z jednotlivých 'X' a mezer vypíše:
# X X X X X X
# X         X
# X         X
# X         X
# X         X
# X X X X X X

def print_empty_square():
    for i in range (6):
        if i ==0 or i == 5:
            for j in range (6):
                print('X ', end='')
            print()
        else:
            print('X   ', 4 * ' ', 'X')

#print_empty_square()

##############################################################################

# Vyber si jeden z předchozích úkolů a uprav jej tak, aby počet řádků a sloupců mohl zadat uživatel.

def print_empty_square_2():
    rozmer = int(input('Zadej rozmer: '))
    for i in range (rozmer):
        if i ==0 or i == (rozmer - 1):
            for j in range (rozmer):
                print('# ', end='')
            print()
        else:
            print('#', (rozmer - 2) * '  ', '#')

#print_empty_square_2()

##############################################################################

# 