# Учебный проект employees_api 
Это мини версия api для базы сотрудников, реализованного на Spring Framework с использованием базы данных h2.

# Описание методов 
1) Создание сотрудника
Аргументы:
* name - Имя сотрудника. Тип данных - String.
* last_name - Фамилия сотрудника. Тип данных - String.
* phone_number - Номер телефона сотрудника. Тип данных - String.
* department_name - название Отдела. Тип данных - String.
Пример запроса:
> localhost:8080/api/create_employee?name=Даниил&last_name=Соловьев&phone_number=89999450338&department_name=Отдел Продаж
2) Вывод существующих сотрудников
Пример запроса:
> localhost:8080/api/employees
3) Вывод сотрудника по его id
Аргументы:
* id - Id сотрудника. Тип данных - Long.
Пример запроса:
> localhost:8080//api/employees/3
4) Редактировние сотрудника по его id
Аргументы:
* id - Id сотрудника. Тип данных - Long.
* name - Имя сотрудника. Тип данных - String.
* last_name - Фамилия сотрудника. Тип данных - String.
* phone_number - Номер телефона сотрудника. Тип данных - String.
* department_name - название Отдела. Тип данных - String.
Пример запроса:
> localhost:8080//api/edit_employee?id=4&name=Даниил&last_name=Соловьев&phone_number=89999450338&department_name=Отдел Продаж
5) Назначение сотрудника в отдел
Аргументы:
* id - Id сотрудника. Тип данных - Long.
* department_name - название Отдела. Тип данных - String.
Пример запроса:
> localhost:8080/api/update_employee_department
6) Удалить сотрудника по его id
Аргументы:
* id - Id сотрудника. Тип данных - Long.
Пример запроса:
> localhost:8080/api/delete_employee/7