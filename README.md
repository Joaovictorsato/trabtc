# Autômatos Finitos
Implementação de um autômato finito em JAVA com linguagem regular.

Sua principal função é identificar uma sequência de caracteres que formam uma palavra específica dentro de um texto.

Dado certo alfabeto, definido nesse caso por `Σ = {E, G, L, O, X}`, o código conterá um arquivo `.txt` o qual pode ser editado e novas palavras podem ser inseridas para análise. O programa reconhecerá apenas palavras as quais contém a sequência de letras que formam **"GOOGLE"**, podendo assim ler várias vezes os caracteres `'G'`, `'O'`, `'E'` em ordem de formação da palavra, ou seja, letras com repetição, e excessão do `'L'`, serão aceitas pelo programa. O resultado mostrará **"válido"** para palavras aceitas e **"não válido"** para palavras não aceitas.



# Instruções de Execução
- Edite o arquivo `.txt` "words" com palavras separadas por linha que serão analisadas pelo programa
- Execute o arquivo `.java` "Run" para executar o programa

# Exemplos de Aplicação
- Lendo a palvra `GOOGLLE` , sua saída será:
```xml
GOOGLLE: nao valido
```
Isso ocorre pois o programa leu dois `L` seguidos, e consequentemente não é aceito.

- Lendo a palavra `GOOOOGGGGLEEE` , sua saída será:
```xml
GOOOOGGGGLEEE: valido
```
Isso ocorre pois o programa leu todas as letras que formam `GOOGLE`, e consequentemente é aceito.

# Autômato Finito Deterministico
![automato description](https://github.com/malumsz/trabtc/blob/main/automato.png)

