import request from '@/utils/request'

//更新属性
export function updateAttribute(data) {
  return request({
    url: '/api/attr/updateAttribute',
    method: 'post',
    data: data
  })
}

// 获取属性
export function getAttribute(query) {
  return request({
    url: '/api/attr/getAttribute',
    method: 'get',
    params: query
  })
}

// 获取某人属性
export function getAttributeList(query) {
  return request({
    url: '/api/userAttrList',
    method: 'get',
    params: query
  })
}

// 获取个人所有小屋
export function getUserHuts() {
  return request({
    url: '/api/hutList/',
    method: 'get'
  })
}

// 获取男女主角
export function getCabinCrew(query) {
  return request({
    url: '/api/hut/info',
    method: 'get',
    params: query
  })
}

// 根据属性id删除属性
export function attrDelete(data) {
  return request({
    url: '/api/userAttrList/del',
    method: 'post',
    data: data
  })
}