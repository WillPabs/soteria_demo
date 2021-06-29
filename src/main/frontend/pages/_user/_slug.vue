<template>
  <article>
    <h1>{{ user.firstName }}</h1>
    <section>
      <p>{{ user.email }}</p>
    </section>
    <button @click="goBack">Back</button>
  </article>
</template>
<script>
  export default {
    head() {
      return {
        title: "User Info"
      }
    },
    data() {
      return {
        user: []
      }
    },
    async fetch({ $http, params }) {
      this.user = await fetch(
        `http://localhost:8888/api/user/${params.slug}`
      )
    },
    methods: {
      goBack() {
        return this.$router.go(-1)
      }
    }
  }
</script>
<style scoped>
  article {
    max-width: 600px;
    margin: 0 auto;
  }
  img {
    height: 200px;
  }
  p {
    text-align: left;
  }
</style>
