<template>
  <div id="login">
    <h1>Login</h1>
    <b-card>
      <b-form>
        <b-form-group id="username-group" label="Username:" label-for="username">
          <b-form-input id="username" type="text" v-model="input.username" required placeholder="Username"/>
        </b-form-group>
        <b-form-group id="password-group" label="Password:" label-for="password">
          <b-form-input type="password" name="password" autocomplete="current-password" v-model="input.password" required placeholder="Password"/>
        </b-form-group>
        <b-button size="lg" variant="outline-secondary" type="button" v-on:click="login()">Login</b-button>
      </b-form>
    </b-card>
    <br>
  </div>
</template>

<script>

export default {
  name: "Login",
  data() {
    return {
      input: {
        username: "",
        password: ""
      }
    }
  },
  methods: {
    login() {
      if(this.input.username == "admin" && this.input.password == "pass") {
        this.$store.commit("setAuthentication", true);
        this.$router.replace({ name: "Admin" });
      } else {
        this.$store.commit("setAuthentication", false);
        console.log(this.$store.state.authenticated)
        console.log("The username and / or password is incorrect");
      }
    }
  }
}
</script>