Пул потоків обслуговується 2-ма робочими потоками й має одну чергу
виконання. Задачі додаються відразу в кінець черги виконання. Черга задач
виконується з інтервалом в 30 секунд (буфер наповнюється задачами на
протязі 30-ти секунд, котрі потім виконуються). Задачі, що додаються під
час виконання черги задач відкидаються. Задача займає випадковий час від
2 до 8 секунд.