<template>
    <div >
        <EditInfo class="px-5"></EditInfo>
        <p class="bold px-5 pt-3 pb-0 text-center">Змінити пароль</p>
        <hr class="line mx-4 my-2">
        <ChangePassword class="px-5"></ChangePassword>
    </div>
</template>

<script>
    import ChangePassword from "../Forms/ChangePassword";
    import EditInfo from "../Forms/EditInfo";

    export default {
        name: "SettingsBlock",
        components: {EditInfo, ChangePassword}
    }
</script>

<style scoped>
    .line {
        border-color: #CD0000;
        border-width: 1.5px;
    }
    .bold {
        font-weight: bold;
    }
</style>