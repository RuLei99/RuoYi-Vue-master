import request from '@/utils/request'

// 查询地区管理列表
export function listDq(query) {
  return request({
    url: '/system/dq/list',
    method: 'get',
    params: query
  })
}

// 查询地区管理详细
export function getDq(id) {
  return request({
    url: '/system/dq/' + id,
    method: 'get'
  })
}

// 新增地区管理
export function addDq(data) {
  return request({
    url: '/system/dq',
    method: 'post',
    data: data
  })
}

// 修改地区管理
export function updateDq(data) {
  return request({
    url: '/system/dq',
    method: 'put',
    data: data
  })
}

// 删除地区管理
export function delDq(id) {
  return request({
    url: '/system/dq/' + id,
    method: 'delete'
  })
}
