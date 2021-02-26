<template>
    <div class="px-5 py-3 flex" >
        <div  v-for="c in categories" :key="c.name">
            <div v-if="c.outcome" class="category-container m-4">
                <i class="fa fa-lg" :class="c.icon"></i>
                <p> {{c.name}}</p>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "OutcomesBlock",
        data() {
            return {
                categories: this.$store.getters['categories']
            }
        }
    }
</script>

<style scoped>
    .category-container{
        text-align: center;
    }

    .flex{
display: inline-flex;
    }
</style>