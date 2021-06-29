<template>
  <p v-if="$fetchState.pending">Fetching Users</p>
  <p v-else-if="$fetchState.error">Error fetching users</p>
  <div v-else>
    <h1>Users</h1>
    <ul v-for="user of users" :key="user.id">
      <NuxtLink :to="`${user._slug}`">
        <li>{{ user.firstName }}</li>
      </NuxtLink>
    </ul>
    <ol>
      <li v-for="user of users">
        {{ user.firstName }} {{ user.lastName }}
      </li>
    </ol>
    <button @click="$fetch">Refresh</button>
  </div>
</template>

<script>
export default {
  head() {
    return {
      title: "User List"
    }
  },
  data() {
    return {
      users: []
    }
  },
  async fetch() {
    this.users = await fetch(
      'http://localhost:8888/api/users'
    ).then((res) => res.json())
  }
}
</script>
