import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";
import Swal from "sweetalert2";

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        admin: {
            id: 0,
            name: "",
            lastName: "",
            email: "",
        },
        token: '',
    },
    getters: {
        isAuthenticated(state) {
            return state.token !== '';
        },
        getAdminCredentials(state) {
            return state.admin;
        }
    },
    mutations: {
        setAdminCredentials(state, data) {
            state.admin = {
                id: data.id,
                name: data.name,
                lastName: data.lastName,
                email: data.email
            };
        },
        setToken(state, token) {
            state.token = token;
        },
        clearToken(state) {
            state.token = '';
        }
    },
    actions: {
        initialize({commit}) {
            const token = localStorage.getItem("token");
            if (token) {
                commit("setToken", token);
                router.push("/users");

            } else {
                return false;
            }
        },
        async login({commit, dispatch}, authData) {
            try {
                const response = await axios.post("login", {...authData});
                Swal.fire({
                        title:'Başarılı',
                        text:'Giriş işlemi başarılı.',
                        icon:'success',
                        timer: 1500,
                    }
                ).then(()=>{
                    dispatch("setAdminCredentials", response.data);
                    commit("setToken", response.data.token);
                    localStorage.setItem("token", response.data.token);
                    router.push("/users");
                });

            }catch (e) {
                Swal.fire(
                    'Başarısız',
                    'Hatalı giriş yaptınız.',
                    'error'
                )
            }
        },
        setAdminCredentials({commit},data) {
            commit("setAdminCredentials", data);
        },
        logout({commit}) {
            commit("clearToken");
            localStorage.removeItem("token");
            router.push("/login");
        }
    },
});
