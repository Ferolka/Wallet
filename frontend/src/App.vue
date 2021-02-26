<template>
    <div id="app">
        <router-view/>
    </div>
</template>

<script>
    const head = document.getElementsByTagName("HEAD")[0];
    const link = document.createElement("link");
    link.rel = "stylesheet";
    link.href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css";
    head.appendChild(link);

    export default {
        name:"App",
        computed : {
            isLoggedIn : function(){ return this.$store.getters.isLoggedIn}
        },
        methods: {
            logout: function () {
                this.$store.dispatch('logout')
                    .then(() => {
                        this.$router.push('/auth')
                    })
            }
        },
    }
</script>

<style >
    @font-face {
        font-family: 'Igra Sans';
        src: local('Igra Sans'), local('IgraSans'),
        url('assets/Fonts/IgraSans.woff') format('woff'),
        url('assets/Fonts/IgraSans.ttf') format('truetype');
        font-weight: normal;
        font-style: normal;
    }

    @font-face {
        font-family: 'Merriweaher';
        src: local('Merriweaher'), local('Merriweaher'),
        url('assets/Fonts/Merriweather-BoldItalic.ttf') format('truetype');
        font-weight: bold;
        font-style: italic;
    }

    h4{
        font-family: 'Merriweaher';
        font-style: italic;
        font-weight: bold;
        font-size: 18px;
        color:black;
    }
    body {
        background: #FAFAFA !important;

    }

    * {
        border-radius: 3px !important;
    }

    a {
        font-family: 'Igra Sans', serif;
    }

</style>
