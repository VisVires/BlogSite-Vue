import axios from 'axios';
import authHeader from '@/services/auth-header';

var baseUrl = process.env.VUE_APP_BASE_URL
const API_URL = baseUrl + '/auth/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();