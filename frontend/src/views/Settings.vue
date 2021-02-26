<template>
    <div>
        <Menu active="settings"></Menu>
        <Header active="none" transactions="upcoming"></Header>
        <div class="justify-content-between align-top">
            <div class="left-block">
                <InfoField page="settings"></InfoField>
            </div>
            <Transactions></Transactions>
        </div>
    </div>
</template>

<script>
    import Menu from '@/components/Basic/Menu.vue'
    import Header from '@/components/Basic/Header.vue'
    import InfoField from "@/components/Basic/InfoField";
    import Transactions from "@/components/Basic/Transactions";

    export default {
        name: "Settings",
        components: {
            Transactions,
            InfoField,
            Menu,
            Header
        }
    }
</script>

<style scoped>
    .left-block {
        margin: 8% 0 0 10%;
        float: left;
        width: 55%;
    }
</style>