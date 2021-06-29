<template>
  <div>
    <h1>User: {{ first }} {{ last }}</h1>
    <h2>Email: {{ mail }}</h2>
    <NuxtLink to="/">Back to Users</NuxtLink>
  </div>
</template>
<script>
  export default {
    async asyncData({ params, redirect }) {
      const users = await fetch(
        'http://localhost:8888/api/users'
      ).then((res) => res.json())

      const filteredUser = users.find(
        (el) =>
          el.slug === params.user
      )
      if (filteredUser) {
        return {
          first: filteredUser.firstName,
          last: filteredUser.lastName,
          mail: filteredUser.email
        }
      } else {
        redirect('/')
      }
    }
  }
</script>
