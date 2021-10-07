<template>
  <v-app>
    <v-main>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-card class="elevation-12">
              <v-toolbar dark color="deep-purple">
                <v-toolbar-title>Giriş Formu</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    v-model="user.username"
                    name="email"
                    label="Eposta"
                    type="text"
                  ></v-text-field>
                  <v-text-field
                    v-model="user.password"
                    id="password"
                    name="password"
                    label="Sifre"
                    type="password"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="deep-purple" dark @click="Login">Giriş</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import {store} from "@/store";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    Login() {
      store.dispatch("login", { username: this.user.username, password: this.user.password });
    },
  },
};
</script>

<style scoped></style>
