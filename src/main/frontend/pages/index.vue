<template>
  <div id="list8">
    <h1>Users</h1>
    <ul>
      <li v-for="user in users" :key="user.id">
        <NuxtLink
          :to="{ name: 'users-slug', params: { id: user.id } }"
        >
          {{ user.firstName }}
        </NuxtLink>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  head() {
    return {
      title: "User List"
    }
  },
  async asyncData({ $http }) {
    const users = await $http.$get(`http://localhost:8888/api/users`)
    return { users }
  }
}
</script>
<style>
  /*!* LIST #8 *!*/
  #list8 ul li { font-family:Georgia,serif,Times; font-size:18px;margin:auto; }
  #list8 ul li a { display:block; width:300px; height:28px; background-color:#333; border-left:5px solid #222; border-right:5px solid #222; padding-left:10px;
    text-decoration:none; color:#bfe1f1; }
  #list8 ul li a:hover {  -moz-transform:rotate(-2deg); -moz-box-shadow:10px 10px 20px #000000;
    -webkit-transform:rotate(-5deg); -webkit-box-shadow:10px 10px 20px #000000;
    transform:rotate(-5deg); box-shadow:10px 10px 20px #000000; }
</style>
