<template>
    <div class="body mb-4">
        <p v-if="page=='settings'" class="bold px-5 pt-3 pb-0 text-center">Налаштування</p>
        <p v-else class="nav bold justify-content-between px-5 pt-3 pb-0"><span>Поточний бюджет</span><span>₴3456</span>
        </p>
        <hr class="line mx-4 my-2">
        <IncomesBlock v-if="page=='incomes'"></IncomesBlock>
        <OutcomesBlock v-if="page=='outcomes'"></OutcomesBlock>
        <StatisticsBlock v-if="page=='stats'"></StatisticsBlock>
        <SettingsBlock v-if="page=='settings'"></SettingsBlock>
    </div>
</template>

<script>
    import OutcomesBlock from "@/components/Nested/OutcomesBlock";
    import StatisticsBlock from "@/components/Nested/StatisticsBlock";
    import IncomesBlock from "@/components/Nested/IncomesBlock";
    import SettingsBlock from "@/components/Nested/SettingsBlock";

    export default {
        name: "InfoField",
        components: {SettingsBlock, IncomesBlock, StatisticsBlock, OutcomesBlock},
        props: ['page']
    }

</script>

<style scoped>
    .body {
        background: #FFF;
        width: 100%;
    }

    .bold {
        font-weight: bold;
    }

    .line {
        border-color: #FE9D04;
        border-width: 1.5px;
    }
</style>