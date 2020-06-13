<template>
  <div class="navbar">
    <b-navbar sticky>
      <b-navbar-brand to="/">WILLIAM GEORGE</b-navbar-brand>
      <b-navbar-nav>
        <b-nav-item to="/">ABOUT ME</b-nav-item>
        <b-nav-item to="/tech">TECH</b-nav-item>
        <b-nav-item to="/projects">PROJECTS</b-nav-item>
        <b-nav-item to="/resume">RESUME</b-nav-item>
        <b-nav-item to="/photography">PHOTOGRAPHY</b-nav-item>
        <b-nav-item v-if="showAdmin" to="/admin">ADMIN</b-nav-item>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>

export default {
  name: "NavBar",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdmin() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }
      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
}

</script>
