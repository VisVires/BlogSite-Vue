<template>
  <div id="login">
    <h1>Login</h1>
    <b-card>
      <b-form name="form" @submit.prevent="handleLogin">
        <b-form-group id="username-group" label="Username:" label-for="username">
          <b-form-input
            v-model="user.username"
            required
            type="text"
            autocomplete="username"
            name="username"
            placeholder="Username"
          />
        </b-form-group>
        <b-form-group id="password-group" label="Password:" label-for="password">
          <b-form-input
            v-model="user.password"
            required
            type="password"
            autocomplete="current-password"
            name="password"
            placeholder="Password"
          />
        </b-form-group>
        <b-form-group>
          <b-button type="Submit">Log In</b-button>
        </b-form-group>
        <b-form-group>
          <div v-if="message" class="alert alert-danger" role="alert">{{message}}</div>
        </b-form-group>
      </b-form>
    </b-card>
    <br>
  </div>
</template>

<script>

import User from '@/models/user';

export default {
  name: "Login",
  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      console.log('loggedIn')
      this.$router.push('/profile');
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$store.dispatch('auth/login', this.user).then(
        () => {
          this.$router.push('/profile');
        },
        error => {
          this.message =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      )
    }
  }
}
</script>