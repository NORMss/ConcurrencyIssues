# Проблемы параллелизма

### Ru/En(./README.md) версия README

### Проблема "Драг-рейсинг"
Найдите способ всегда получать 2_000_000.
[Предоставленный код](./src/main/kotlin/prblemDragRacing/problem.kt) демонстрирует проблему параллелизма, известную как **состояние гонки**.
#### Объяснение проблемы
- **Общее состояние**: переменная `counter` используется совместно двумя потоками (`firstWorker` и `secondWorker`).
- **Операция увеличения (`counter++`)**: эта операция не является атомарной. Она состоит из нескольких шагов:
  1. Чтение текущего значения `counter`.
  2. Увеличение значения.
  3. Запись нового значения обратно в память.

Когда два потока одновременно выполняют `counter++`, они могут считывать одно и то же начальное значение `counter`, что приводит к неверным результатам (например, некоторые увеличения могут быть «потеряны»).

### Наблюдаемое поведение
Конечное значение `counter` является **недетерминированным** и обычно меньше ожидаемого результата `2_000_000`. Это происходит из-за перекрытия и помех между двумя потоками при доступе и изменении `counter`.

#### Ключевая концепция: Состояние гонки
**Состояние гонки** возникает, когда корректность программы зависит от времени или последовательности потоков. В этом случае состояние гонки возникает, потому что потоки конкурируют за изменение общей переменной `counter` без надлежащей синхронизации.
#### Решения
1. Используйте [Atomic Variables](./src/main/kotlin/prblemDragRacing/solutionWithAtomic.kt)
2. Используйте [ReentrantLock(Mutex)](./src/main/kotlin/prblemDragRacing/solutionWithReentrantLock.kt)
3. Используйте [Semaphore](./src/main/kotlin/prblemDragRacing/solutionWithSemaphore.kt)

### Проблема "Передай водичку"
Объясните своими словами, почему приложение зависает. Приведенный код демонстрирует проблему параллелизма, известную как взаимоблокировка.
#### Объяснение проблемы
![image](https://github.com/user-attachments/assets/e31018b0-589a-46db-8c98-3a01c3cb3075)

#### Ключевая концепция: взаимоблокировка
**Взаимоблокировка** происходит, когда два или более потоков:
  1. Получают разные блокировки.
  2. Каждый поток ждет, пока другой снимет свою блокировку.
  3. Ни один поток не может продолжить работу, так как все ждут бесконечно.
#### Решение
1. **[Глобальный порядок блокировки](./src/main/kotlin/problemPassMeSomeWater/solution.kt)**:
Убедитесь, что оба потока получают блокировки в одном и том же порядке