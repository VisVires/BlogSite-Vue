<template>
  <div class="sidebar" id="sidebar">
    <b-list-group vertical tabs>
      <b-list-group-item to="/" exact exact-active-class="active" class="sidebar-list-group">ABOUT ME</b-list-group-item>
      <b-list-group-item to="/tech" exact exact-active-class="active" class="sidebar-list-group">TECH</b-list-group-item>
      <b-list-group-item to="/projects" exact exact-active-class="active" class="sidebar-list-group">PROJECTS</b-list-group-item>
      <b-list-group-item to="/resume" exact exact-active-class="active" class="sidebar-list-group">RESUME</b-list-group-item>
      <b-list-group-item to="/photography" exact exact-active-class="active" class="sidebar-list-group">PHOTOGRAPHY</b-list-group-item>
      <b-list-group-item v-if="showAdmin" to="/admin" exact exact-active-class="active" class="sidebar-list-group">ADMIN</b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>

export default {
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
  }
}

</script>
