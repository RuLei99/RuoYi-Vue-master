import request from '@/utils/request'

// 查询天气管理列表
export function listDetail(query) {
  return request({
    url: '/system/detail/list',
    method: 'get',
    params: query
  })
}

// 查询天气管理详细
export function getDetail(id) {
  return request({
    url: '/system/detail/' + id,
    method: 'get'
  })
}

// 新增天气管理
export function addDetail(data) {
  return request({
    url: '/system/detail',
    method: 'post',
    data: data
  })
}

// 修改天气管理
export function updateDetail(data) {
  return request({
    url: '/system/detail',
    method: 'put',
    data: data
  })
}

// 删除天气管理
export function delDetail(id) {
  return request({
    url: '/system/detail/' + id,
    method: 'delete'
  })
}
export function qwyc(city) {
  return request({
    url: '/system/detail/qwyc?city='+city,
    method: 'get'
  })
}
export function sdyc(city) {
  return request({
    url: '/system/detail/sdyc?city='+city,
    method: 'get'
  })
}
export function qyyc(city) {
  return request({
    url: '/system/detail/qyyc?city='+city,
    method: 'get'
  })
}

export function ghyj(params) {
  return request({
    url: '/system/detail/ghyj',
    method: 'get',
    params
  })
}
export function hlyj(params) {
  return request({
    url: '/system/detail/hlyj',
    method: 'get',
    params
  })
}
export function hhyj(params) {
  return request({
    url: '/system/detail/hhyj',
    method: 'get',
    params
  })
}
export function rhyj(params) {
  return request({
    url: '/system/detail/rhyj',
    method: 'get',
    params
  })
}

export function zhtj() {
  return request({
    url: '/system/detail/dpfx',
    method: 'get'
  })
}

