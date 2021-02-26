<template>
    <div class="p-5 login-bg">
        <h4 class="px-2 text-white">Уже є акаунт?</h4>
        <hr class="red-line">
        <form class="login" @submit.prevent="login">
            <div class="input-group  my-3">
                <label for="signin_login" class=" pt-2 text-white label">Логін:</label>
                <input v-model="email" type="email" class="form-control input mx-3" id="signin_login"  required="required" /></div>
            <div class="input-group  my-3"><label for="signin_pass" class="pt-2 text-white label" >Пароль:</label>
                <input v-model="password" type="password" class="form-control input mx-3" id="signin_pass" minlength="8" required="required"/>
            </div>
            <button type="submit" class="btn btn-outline-warning float-right border-yellow my-3 mx-3 px-lg-5">Вхід
            </button>
        </form>
    </div>
</template>

<script>
    export default {
        name:"Login",
        data(){
            return {
                email : "",
                password : ""
            }
        },
        methods: {
            login: function () {
                let email = this.email;
                let password = this.password;
                this.$store.dispatch('login', { email, password })
                    .then(() => this.$router.push('/'))
                    .catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>
    .border-yellow {
        border: 2px solid #FFBF00;
        color: white !important;
    }

    .login-bg {
        background: rgba(255, 255, 255, 0.3);
        height: 80vh;
    }

    .red-line {

        border-color: #CC0000;
        border-width: 1.5px;
    }

    .label {
        text-align: right;
        float: left !important;
        width: 25%;
        padding-right: 5%;
    }

    .input {
        float: right;
        width: 65%;
    }
</style>