# Конвертер температуры
`master`

![master_branch_testing](https://github.com/LyashenkoValeria/TempConverter/actions/workflows/test_ci.yml/badge.svg?branch=master)

`develop`

![develop_branch_testing](https://github.com/LyashenkoValeria/TempConverter/actions/workflows/test_ci.yml/badge.svg?branch=develop)

В результате выполнения лабораторной работы был создан сервис, 
который может конвертировать температуру заданную в одной из трёх величин: Цельсия, Фаренгейты, Кельвины.
## Задачи
https://docs.google.com/spreadsheets/d/1OyPGjsVzCO3-em4qTDRFeMtoDHuOynbhWttolWWro-E/edit?usp=sharing

## Описание работы
Для работы используются три флага, указывающие единицу измерения, в которой задано входное значение:
`-c` - Цельсия;
`-f` - Фаренгейты;
`-k` - Кельвины.

Величины, в которые необходимо перевести, указываются символами `c|f|k`.

Для получения информации о работе сервиса используется команда `-help`.

## Пример работы
```
Enter the command or use -help:
-help
The converter supports three types of temperature:
-c - Celsius;
-f - Fahrenheit;
-k - Kelvin.
To get the result, enter one of the three flags and a number, then write one or two values to which you want to convert the original value.
Example:
-c 40 fk.
Result:
Fahrenheit value: 104,000
Kelvin value: 313,150

Enter your command:
-c 40 kf
Kelvin value: 313,150
Fahrenheit value: 104,000
```
## Запуск Docker
1. Собираем образ Docker с помощью: docker build . -t temp_converter
2. Запускаем контейнер: docker run -it temp_converter
