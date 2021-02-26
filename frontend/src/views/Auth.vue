<template>
    <div>
        <div class="header">
        </div>
        <div class="image-container"> </div>
        <div class="justify-content-between align-content-center" >
            <Login class="half"></Login>
            <Registry class="half"></Registry>
        </div>
        <div class="footer py-3 px-5">
            <span class="px-2 my-5">Зв'язатися з нами:</span>
            <span class="px-2 py-2"><b-icon-envelope-open-fill></b-icon-envelope-open-fill>
            moneypot@gmail.com</span>

        </div>
    </div>
</template>

<script>
    import Login from "@/components/Forms/Login";
    import Registry from "@/components/Forms/Registry";
    import {BIconEnvelopeOpenFill} from 'bootstrap-vue'

    export default {
        name: "Auth",
        components: {Registry, Login, BIconEnvelopeOpenFill}
    }
</script>

<style scoped>

.base{
    background: #FAFAFA;
}
    .header {
        height: 10vh;
        width: 100%;
        background: linear-gradient(120deg, #FFB800 14.06%, #CC0000 100%);
        border-radius: 0 !important;
    }

    .footer {
        height: 10vh;
        position: fixed;
        bottom: 0;
        left: 0;
        width: 100%;
        background: #202327;
        border-radius: 0 !important;
        font-style: italic;
        color: #828282;
    }

    .half{
        width:50%;
        display: inline-block;
        overflow: hidden;
    }
    .image-container{
        width:50%;
        margin: 0;
        display: inline-block;
        position: absolute;
        left:0;
        top:50px;
        height: 90vh;
        background:  url("../assets/blackvisa-1.jpg") no-repeat center center fixed;
        background-size: cover;
        border-radius: 0!important;
        z-index: -1;
    }

</style>