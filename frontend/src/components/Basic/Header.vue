<template>
    <nav class=" header justify-content-between ">
        <div class="header-left nav nav-fill">
            <a class="nav-link text-dark btn btn-outline-warning active-left header-item"
                         @click="setCurrentPage(outcomes)"
                         :class="{activeLeft: currentPage == outcomes,
                         inactive:currentPage!=outcomes}">
                Витрати
            </a>
            <a  @click="setCurrentPage(incomes)" class="nav-link text-dark btn btn-outline-warning header-item"
                         :class="{activeLeft: currentPage == incomes,
                         inactive:currentPage!=incomes}">
                Доходи
            </a>
            <a class="nav-link text-dark btn btn-outline-warning header-item"
                         @click="setCurrentPage(statistic)"
                         :class="{activeLeft: currentPage == statistic,
                         inactive:currentPage!=statistic}">
                Статистика
            </a>
        </div>
        <div class="header-right nav nav-fill " v-if="currentLogState!=idle">
            <a class="nav-link text-dark btn btn-outline-danger header-item"
                         :class="{activeRight: currentLogState == upcoming,
                         inactive:currentLogState!=upcoming}" @click="setLogState(upcoming)">Заплановані</a>
            <a class="nav-link text-dark btn btn-outline-danger header-item"
                         :class="{activeRight: currentLogState == recent,
                         inactive:currentLogState!=recent}" @click="setLogState(recent)">Журнал</a>

        </div>
    </nav>
</template>

<script>
    import {LogState} from "@/models/entities/LogPage";
    import {CurrentPage} from "@/models/entities/CurrentPage";

    export default {
        name: "Header",
        props: ['active','transactions'],
        data(){
            return {
                upcoming:LogState.UPCOMING,
                recent:LogState.RECENT,
                idle:LogState.IDLE,
                currentLogState:this.$store.getters['logState'],
                currentPage:this.$store.getters['currentPage'],
                outcomes:CurrentPage.OUTCOMES,
                incomes:CurrentPage.INCOMES,
                statistic: CurrentPage.STATISTIC
            }
        },
        methods:{
            setLogState: function (newLogState) {
                this.$store.dispatch('changeLogState', newLogState)
                    .then(() => this.currentLogState=this.$store.getters['logState'])
                    .catch(err => console.log(err))
            },
            setCurrentPage: function (newPage) {
                this.$store.dispatch('changeCurrentPage', newPage)
                    .then(()=> {
                        this.$router.push('/'+newPage);
                        this.currentPage = this.$store.getters['currentPage'];
                        if(this.currentLogState==LogState.IDLE)
                            this.$store.dispatch('changeLogState', LogState.UPCOMING);
                    })
                    .catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped >
    .header {
        font-size: 12px;
        margin-left: 5%;
        padding: 2% 5% 1% 5%;
        display: inline-flex;
        width: 95%;
        background: #FAFAFA;
        border-radius: 0 !important;
        position: fixed;
        z-index: 2;
    }

    .header-left {
        font-family: 'Igra Sans' !important;
        width: 60%;
    }

    .header-right {
        font-family: "Igra Sans" !important;
        width: 29.5%;
    }

    .header-item{
        font-size: 12px;
        border:2px solid transparent;
    }
    .activeLeft {
        border-color: #FFBF00;
    }

    .inactive {
        border-color:transparent;
    }

    .activeRight {
        border-color: #CD0000;
    }
</style>