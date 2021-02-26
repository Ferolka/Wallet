<template>

    <div class="body mb-4">
        <b-button v-b-toggle.collapse-1 class="closed-spoiler px-4 input-group" variant="outlined-light">
            Нова транзакція
            <span class="icon-holder"><b-icon-plus></b-icon-plus></span>
        </b-button>
        <b-collapse id="collapse-1" class="opened-spoiler mx-0 p-0">
            <b-card class="my-card-body p-1">
                <form class="transaction" @submit.prevent="transaction">
                    <div class="row p-0">
                        <div class="col p-0">
                            <div>
                                <div class="form-group  mx-3 mb-3">
                                    <label for="transaction">Назва транзакції</label>
                                    <input v-model="transaction_name" type="text" class="form-control col-md-12 input-sm" id="transaction" required="required">
                                </div>
                                <div class="form-group mx-3 mb-3">
                                    <label for="transaction" >Тип транзакції</label>
                                    <div>
                                        <div class="form-check form-check-inline col-md-3">
                                            <input v-model="transaction_outcome" class="form-check-input " type="radio" name="exampleRadios"
                                                   id="transaction_outcome" value="outcome" checked>
                                            <label class="form-check-label" for="transaction_outcome">
                                                Витрата
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline col-md-3 mx-3">
                                            <input v-model="transaction_income" class="form-check-input" type="radio" name="exampleRadios"
                                                   id="transaction_income" value="income">
                                            <label class="form-check-label" for="transaction_income">
                                                Прибуток
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mx-3 mb-3 ">
                                    <label for="transaction">Кошти</label>
                                    <div class="input-group ">
                                        <div class="input-group-prepend ">
                                            <span class="input-group-text">₴</span>
                                        </div>
                                        <input v-model="transaction_sum" type="number" class="form-control col-md-12" required="required">
                                    </div>
                                </div>
                                <div class="form-group mx-3 mb-3">
                                    <label for="category" class="  ">Категорія</label>
                                    <select v-model="category" class="custom-select p-2 " id="category" required>
                                        <option v-for="c in categories" :key="c.name" :value="c.name">{{c.name}}</option>
                                    </select></div>
                            </div>

                        </div>
                        <div class="vl "></div>
                        <div class="col">
                            <div>
                                <div class="px-3">
                                    <div class="form-group mt-3 mb-2">
                                        <div class="custom-control custom-switch ">
                                            <input v-model="remote_transaction" type="checkbox" class="custom-control-input"
                                                   id="remote_transaction" >
                                            <label class="custom-control-label"
                                                   for="remote_transaction">Відкласти транзакцію</label>
                                        </div>
                                    </div>
                                    <div class="form-group mt-3 mb-2">
                                            <div class="form-group">
                                                <label for="inputDate" >Встановити дату:</label>
                                                <input v-model="inputDate" type="date" class="form-control" id="inputDate" required="required">
                                            </div>
                                    </div>
                                    <hr>
                                    <div class="form-group">
                                            <div >
                                                <label  for="repeatDate" >Повторювати
                                                    щомісяця</label>
                                                <input v-model="repeatDate" type="date" class="form-control" id="repeatDate" required="required">
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4">
                        <button type="submit" class="btn btn-outline-warning m-0 text-white btn-orange btn-block">Додати
                            транзакцію
                        </button>
                    </div>
                </form>
            </b-card>
        </b-collapse>
    </div>
</template>

<script>
    import {BCollapse, BButton, BCard, BIconPlus} from 'bootstrap-vue';

    export default {
        name:"NewTransaction",
        data(){
            return {
                transaction_name : "",
                transaction_income: "",
                transaction_outcome: "",
                transaction_sum: "",
                category:"",
                remote_transaction: "",
                inputDate: "",
                repeatDate: "",
                categories:this.$store.getters['categories']
            }
        },
        methods: {
            transaction: function () {
                let data = {
                    transaction_name : this.transaction_name,
                    transaction_income : this.transaction_income,
                    transaction_outcome : this.transaction_outcome,
                    transaction_sum : this.transaction_sum,
                    category: this.category,
                    remote_transaction: this.remote_transaction,
                    inputDate :this.inputDate,
                    repeatDate : this.repeatDate

                };
                this.$store.authModule.dispatch('transaction', data)
                    .then(() => this.$router.push('/'))
                    .catch(err => console.log(err))
            }
        },
        components: {BCollapse, BButton, BCard, BIconPlus}
    }
</script>

<style scoped>
    .body {
        width: 100%;
    }

    .closed-spoiler {
        border: 2px solid #E5E5E5;
        border-radius: 3px;
        width: 100%;
        background: white;
        text-align: left;
        position: relative;
    }

    .closed-spoiler:active, .closed-spoiler:focus {
        box-shadow: none !important;
    }

    .opened-spoiler {
        background: white;
        border: none;
        border-radius: 0 !important;
    }

    .my-card-body {
        background: white;
        margin: 0;
        border: none;
    }

    .btn-orange {
        background: #FE9D04;
        font-family: 'Igra Sans';
        font-size: 14px;
    }

    .btn-orange:hover {
        background: #ffab02;
    }

    .icon-holder {
        position: absolute;
        top: 0;
        right: -1px;
        color: #ffffff;
        background: #93D800;
        height: 100%;
    }

    .icon-holder svg {
        height: 100% !important;
        width: auto;
    }

    .vl {
        border-left: 1px solid lightgrey;
        height: auto;
    }
</style>