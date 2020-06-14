<template>
  <div id="register">
    <b-card>
      <b-form name="form" @submit.prevent="handleRegister">
          <b-form-group>
            <label for="username">Username</label>
            <b-form-input
              v-model="user.username"
              required
              type="text"
              autocomplete="username"
              name="username"
            />
          </b-form-group>
          <b-form-group>
            <label for="password">Password</label>
            <b-form-input
              v-model="user.password"
              required
              type="password"
              autocomplete="current-password"
              name="password"
            />
          </b-form-group>
          <b-form-group>
            <b-button type="Submit">
              <span v-show="loading" class="spinner-border spinner-border-sm"></span>
              <span>Login</span>
            </b-button>
          </b-form-group>
      </b-form>
      <div
        v-if="message"
        class="alert"
        :class="successful ? 'alert-success' : 'alert-danger'"
      >{{message}}</div>
    </b-card>
  </div>
</template>

<script>
import User from '@/models/user';

export default {
  name: 'Register',
  data() {
    return {
      user: new User('', '', ''),
      submitted: false,
      successful: false,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleRegister() {
      this.message = '';
      this.submitted = true;
      this.$store.dispatch('auth/register', this.user).then(
        data => {
          this.message = data.message;
          this.successful = true;
        },
        error => {
          this.message =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
          this.successful = false;
        }
      )
    }
  }
}
</script>