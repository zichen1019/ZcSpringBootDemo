import request from '@/utils/request'

export function getSeverToken() {
  return request({
    url: '/api/token/info',
    method: 'get'
  })
}

export function loginByUsername(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '/api/user/info',
    method: 'post',
    data: data
  })
}

export function logout() {
  return request({
    url: '/login/logout',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: '/api/user/getinfo',
    method: 'get',
    params: { token }
  })
}

