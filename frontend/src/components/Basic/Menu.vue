<template>
    <div class="vertical-menu gradient">
        <h1 class="currency_sign">
            ₴
        </h1>
        <a @click="setCurrentPage(calendar)" class="menu-icon calendar-icon"
                     :class="{menuIconActive: currentPage == calendar}">
           <i class="fa fa-calendar fa-lg"/>
        </a>
        <a @click="setCurrentPage(settings)" class="menu-icon settings-icon"
                     :class="{menuIconActive: currentPage == settings}">
            <b-icon-gear/>
        </a>
        <a @click="setCurrentPage(auth)" class="menu-icon exit-icon">
            <b-icon-box-arrow-right/>
        </a>
    </div>
</template>

<script>
    import {BIconBoxArrowRight, BIconGear} from 'bootstrap-vue'
    import {LogState} from "@/models/entities/LogPage";
    import {CurrentPage} from "@/models/entities/CurrentPage";

    export default {
        name: "Menu",
        components: {
            BIconBoxArrowRight,
            BIconGear
        },
        props: ['active'],
        data(){
            return {
                currentPage:this.$store.getters['currentPage'],
                calendar:CurrentPage.CALENDAR,
                settings:CurrentPage.SETTINGS,
                auth: CurrentPage.AUTH
            }
        },
        methods:{
            setCurrentPage: function (newPage) {
                this.$store.dispatch('changeCurrentPage', newPage)
                    .then(()=> {
                        this.$router.push('/'+newPage);
                        this.currentPage = this.$store.getters['currentPage'];
                        if(this.currentPage==this.auth||this.currentPage==this.calendar)
                            this.$store.dispatch('changeLogState', LogState.IDLE)

                    })
                    .catch(err => console.log(err))
            }
        }

    }
</script>

<style scoped>
    .vertical-menu {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 5%;
        border-radius: 0!important;
    }

    .gradient {
        background: linear-gradient(180deg, #FFB800 14.06%, #CC0000 100%);
    }

    .currency_sign {
        font-family:Calibri;
        padding-top: 20px;
        font-size: 48px;
        font-weight: 800;
        text-align: center;
    }

    .menu-icon {
        width: 5%;
        padding-top: 10px;
        padding-bottom: 10px;
        position: fixed;
        color: black;
        text-align: center;
        cursor: pointer;
    }


    .menuIconActive {
        color: white;
        background: rgba(255, 255, 255, 0.3)!important;
    }

    .menu-icon svg {
        width: 40%;
        height: 40%;
    }

    .exit-icon {
        bottom: 50px;
    }

    .settings-icon {
        bottom: 100px;
    }

    .calendar-icon {
        bottom: 150px;
    }

</style>