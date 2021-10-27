# Утилиты zip и find
[![Build Status](https://travis-ci.com/saimon494/job4j_design.svg?branch=main)](https://travis-ci.com/saimon494/job4j_design)
[![codecov](https://codecov.io/gh/saimon494/job4j_design/branch/main/graph/badge.svg)](https://codecov.io/gh/saimon494/job4j_design)
---
# Содержание
1. [Утилита zip](#Утилита-zip)
2. [Утилита find](#Утилита-find)
## Утилита zip

### О проекте
Проект предназначен для архивирования указанной папки с сохранением структуры подпапок.
Есть возможность передать в качестве ключа расширение файлов, которые не нужно включать в архив.
[Исходный код](https://github.com/saimon494/job4j_design/tree/main/chapter_002/src/main/java/ru/job4j/io) проекта. Пример запуска:
```
java -jar zip.jar -d=chapter_002 -e=*.xml -o=chapter_002/chapter_002.zip
```
-d - папка для архивации  
-e - файлы для исключения  
-o - папка для сохранения архива   

### Сборка
1. Скачать и установить JDK 14.
2. Скачать из [папки](https://github.com/saimon494/job4j_design/tree/main/chapter_002/target) файл `chapter_002-2.jar`.
3. Перейти в директорию c этим файлом.

### Использование
Архивируем папку chapter_002, запустив `chapter_002-2.jar` командой:
```
java -cp chapter_002-2.jar ru.job4j.io.Zip -d=C:\projects\job4j_design\chapter_002 -e=.xml -o=C:\projects\job4j_design\chapter_002.zip
```
![Zip1](images/zip1.PNG)

Распаковав полученный архив, можно убедиться, что в нём отсутствуют файлы с расширением xml.

![Zip2](images/zip2.PNG)

## Утилита find

### О проекте
Проект предназначен для поиска файлов в заданном каталоге и подкаталогах.
Имя файла может задаваться целиком, по маске или по регулярному выражению. Результат поиска записывается в выходной файл.
Есть валидация входных параметров. Исходный код проекта располагается в папке
[chapter_002](https://github.com/saimon494/job4j_design/tree/main/chapter_002/src/main/java/ru/job4j/io/search). 


## Контакты
[![Telegram](https://img.shields.io/badge/Telegram-blue?logo=telegram)](https://t.me/Saimon494)