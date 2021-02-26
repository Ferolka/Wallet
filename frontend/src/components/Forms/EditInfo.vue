<template>

    <div>
        <div class="px-2 py-4 login-bg">
            <form @submit.prevent="changeName">
                <div class="form-group">
                    <label for="change_nickname" class="font-weight-bold">Ім'я користувача</label>
                    <input v-model="name" type="text" class="form-control col-lg-12" id="change_nickname" placeholder="Current nickname" minlength="2" required="required">
                </div>
                <div class="form-group">
                    <label for="email" class="font-weight-bold">Електронна пошта</label>
                    <input v-model="email" type="email" class="form-control col-lg-12" id="email" placeholder="Current email" required="required">
                </div>
                <button type="submit" class="btn btn-warning text-black border-red col-lg-6 my-3 text-white">
                    Зберегти
                </button>

            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name:"EditInfo",
        data(){
            return {
                name : "",
                email : "",
            }
        }, methods: {
            changeName: function () {
                let data = {
                    name: this.name,
                    email: this.email,
                    password: this.password
                };
                this.$store.authModule.dispatch('changeName', data)
                    .then(() => this.$router.push('/'))
                    .catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>

</style>