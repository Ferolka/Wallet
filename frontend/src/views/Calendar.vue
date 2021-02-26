<template>
    <div>
        <Menu active="calendar"></Menu>
        <Header active="none" transactions="none"></Header>
        <div class="body pt-4 justify-content-between">
            <div class="py-3 px-5 calendar-card">
                <h2 class="sprint-header">Sprint 1</h2>
                <hr>
                <ul class="success">
                    <li>Технічне завдання</li>
                    <li>Прототип веб-застосунку</li>
                    <li>Модель бази даних</li>
                </ul>
                <ul class="success">Розробка веб-застосунку:
                    <li>Розробка основної фронтенд-архітектури</li>
                    <li>Розробка основної бекенд-архітектури</li>
                    <li>Заповнення бази даних</li>
                    <li>Верстка сайту</li>

                </ul>
            </div>
            <div class="py-3 px-5 calendar-card">
                <h2 class="sprint-header">Sprint 2</h2>
                <hr>
                <ul class="empty">Розробка веб-застосунку:
                    <li>Перегляд витрачених коштів за категоріями</li>
                    <li>Авторизація</li>
                    <li>Редагування налаштувань користувача</li>
                    <li>Створення миттєвої транзакції обох типів</li>
                    <li>Створення відкладених транзакцій</li>
                    <li>Перегляд статистики</li>
                    <li>Нагадування про відкладені транзакції</li>
                </ul>
              </div>
        </div>
    </div>
</template>

<script>
    import Menu from '@/components/Basic/Menu.vue'
    import Header from '@/components/Basic/Header.vue'

    export default {
        name: "Calendar",
        components: {
            Menu,
            Header
        }
    }

</script>

<style scoped>

    .success ::marker {
        color: #93D800;
        font-size: 25px;
    }

    .empty ::marker {
        color: #E5E5E5;
        font-size: 25px;
    }

    li {
        list-style-type: square;
    }

    .body {
        margin:6% 5% 0 10%;
        display: inline-flex;
        width: 85%;
    }

    .calendar-card {
        background: #FFF;
        width: 47%;
    }

    .sprint-header {
        font-size: 20px;
        font-weight: 800;
        font-style: normal;
        text-align: center;
    }
</style>