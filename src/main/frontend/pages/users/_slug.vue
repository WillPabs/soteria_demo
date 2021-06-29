<template>
  <article>
    <h1>{{ user.firstName }}  {{ user.lastName }}</h1>
    <section>
      <p>Id : {{ user.id }}</p>
      <p>Email : {{ user.email }}</p>
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
    async asyncData({ $http, params }) {
      const user = await $http.$get(
        `http://localhost:8888/api/user/${params.id}`
      )
      return { user }
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
  section {
    font-family:Georgia,serif,Times; font-size:18px;margin:auto;background-color:#333; border-left:5px solid #222; border-right:5px solid #222; padding-left:10px;
    text-decoration:none; color:#bfe1f1;
  }
  p {
    text-align: center;
  }
</style>
