# Задание для собеседования

### Задача 0
Развернуть контроллер, который слушает запросы 
по адресу http://localhost:8082/{название-приложения}. 
Добавить необходимые классы и аннотации для работы с БД. 
Настроить подключение к БД по адресу localhost:5432, к бд service, 
с пользователем interviewer и паролем three_tasks.

### Задача 1
Сделать новый эндпоинт, где в запросе в хедере  передаётся список id сущностей в БД. 
Если они все есть в БД, то вернуть все сущности. 
Если нет, то кинуть ошибку и в тексте написать те id, которых в БД нет.
Постараться сделать максимально оптимально по времни. 

### Задача 2
Сделать новый эндпоинт, где в запросе в query параметрах передаётся code и sysname.
Вернуть общий список без повторений, состойщий из следующих записей:
* Если передан code, надо найти в БД сущности с таким же code.
* Если передан sysname, надо найти в БД сущности с таким же sysname.
* Если ничего не передано, вернуть всё что есть в БД.

### Задача 3
В запросе в пути передаётся sysname. 
По этому sysname найти список объектов из БД. 
Вернуть список найденных объектов и кол-во непрочитанных объектов из этого списка. Непрочитанные объекты те, у ё
которых watched_dttm = null. 
Если непрочитанных нет, вернуть пустой список.
