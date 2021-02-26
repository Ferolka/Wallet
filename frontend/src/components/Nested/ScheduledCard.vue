<template>
    <div class="card px-3 pt-3 mb-2">
        <p class="bold text-income text-18 mb-0">$100
            <span class="float-right regular text-14 text-gray">
                <b-icon-arrow-clockwise/> щомісяця
            </span>
        </p>
        <p class="mb-3"> Назва транзакції</p>
        <p class="nav justify-content-between text-14 text-gray mb-2">
            <span>Категорія</span>
            <span>назва категорії</span>
        </p>
        <p class="nav justify-content-between text-14 text-gray">
            <span>Дата та час</span>
            <span>2021-01-31 10:00</span>
        </p>
        <div class="nav justify-content-between d-inline-flex py-1">
            <button class="text-income btn w-50">Підтвердити</button>
            <button class="text-outcome btn w-50 ">Відхилити</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ScheduledCard"
    }
</script>

<style scoped>

</style>