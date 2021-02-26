<template>
    <div class="p-5 login-bg">
        <h4 class="px-2">Створити акаунт</h4>
        <hr class="red-line">
        <form @submit.prevent="register">
            <div class="input-group  my-3">
                <label for="reg_email" class=" pt-2 text-black label">Email:</label>
                <input v-model="email" type="email" class="form-control input mx-3" id="reg_email" required="required"/></div>
            <div class="input-group  my-3">

                <!--//TODO: check if existing nickname is not in DB -->

                <label for="reg_nickname" class=" pt-2 text-black label">Нікнейм:</label>
                <input v-model="name" type="text" class="form-control input mx-3" id="reg_nickname" minlength="2" required="required"/>
            </div>
            <div class="input-group  my-3">

                <label for="reg_pass" class="pt-2 text-black label">Пароль:</label>
                <input v-model="password" type="password" class="form-control mx-3 input" id="reg_pass" minlength="8" required="required"/>
            </div>
            <button type="submit" class="btn btn-outline-danger text-black float-right border-red my-3 mx-3 px-lg-5">
                Зареєструватись
            </button>

        </form>

    </div>
</template>

<script>
    export default {
        name:"Registry",
        data(){
            return {
                name : "",
                email : "",
                password : "",
            }
        }, methods: {
            register: function () {
                let data = {
                    name: this.name,
                    email: this.email,
                    password: this.password
                };
                this.$store.authModule.dispatch('register', data)
                    .then(() => this.$router.push('/'))
                    .catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>

    .border-red {
        border: 2px solid #CC0000;
        color: black !important;
    }

    .login-bg {
        background: #fafafa;
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