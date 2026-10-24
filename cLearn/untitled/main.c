#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAXSIZE 20

// 定义顺序表
struct sqList {
    int arr[MAXSIZE];
    int size;
};

// 随机生成长度为10的顺序表
struct sqList creat_sq_list() {
    struct sqList sqList;
    sqList.size = 0;
    for (int i = 0; i < 10; i++) {
        sqList.arr[i] = rand() % 100;
        sqList.size++;
    }
    return sqList;
}

// 看看a存不存在
int isExist(int a, struct sqList sqlist) {
    for (int i = 0; i < sqlist.size; i++) {
        if (sqlist.arr[i] == a) {
            return i;
        }
    }
    return -1;
}

// 把b插入a后面
void insert(int a, int b, struct sqList *sqlist) {
    // a存在
    int idx = isExist(a, *sqlist);
    if (idx != -1) {
        for (int i = sqlist->size - 1; i > idx; i--) {
            sqlist->arr[i + 1] = sqlist->arr[i];
        }
        sqlist->arr[idx + 1] = b;
    } else {
        sqlist->arr[sqlist->size] = b;
    }
    sqlist->size++;
}

// 打印顺序表
void printList(struct sqList sqList) {
    for (int i = 0; i < sqList.size; i++) {
        printf("%d ", sqList.arr[i]);
    }
    printf("\n");
}

// 删除元素
int deleteE(int a, struct sqList *sqList) {
    int idx = isExist(a, *sqList);
    if (idx != -1) {
        for (int i = idx; i < sqList->size-1; i++) {
            sqList->arr[i] = sqList->arr[i+1];
        }
        sqList->size--;
        return 1;
    }
    return 0;
}
// 交换a，b的值
void swap(int *a, int*b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

// 顺序表的冒泡排序，排序后是非递减有序表
void mySort(struct sqList *sqList) {
    for (int i = 0; i < sqList->size-1; i++) {
        for (int j = 0; j < sqList->size-1-i; j++) {
            if (sqList->arr[j] > sqList->arr[j+1]) {
                swap(&sqList->arr[j],&sqList->arr[j+1]);
            }
        }
    }
}

// 归并两个非递减有序表
struct sqList mergeSqList(struct sqList sql1,struct sqList sql2) {
    int j = 0;
    for (int i = sql1.size; i < sql1.size+sql2.size-1; i++) {
        sql1.arr[i] = sql2.arr[j];
        j++;
    }
    sql1.size += sql2.size;
    mySort(&sql1);
    return sql1;
}
int main(void) {
    srand((unsigned) time(NULL));
    printf("随机生成一个顺序表：");
    struct sqList sqList = creat_sq_list();
    printf("显示顺序表中的元素：\n");
    printList(sqList);
    printf("\n");
    printf("把值为b的元素插入值为a的元素后面\n");
    printf("请输入a,b：");
    int a, b;
    scanf("%d%d", &a, &b);
    insert(a, b, &sqList);
    printf("显示更新后的顺序表：\n");
    printList(sqList);
    printf("删除值为a的元素\n");
    printf("请输入a：");
    scanf("%d",&a);
    if (deleteE(a,&sqList) == 0) {
        printf("未找到该元素，请重新输入：");
        scanf("%d",&a);
    }
    printf("显示更新后的顺序表：\n");
    printList(sqList);
    printf("随机生成两个非递减有序表：\n");
    struct sqList sql1 = creat_sq_list();
    struct sqList sql2 = creat_sq_list();
    // 排序为非递减有序表
    mySort(&sql1);
    mySort(&sql2);
    // 输出
    printList(sql1);
    printList(sql2);
    printf("归并两个有序表：\n");
    struct sqList sql3 = mergeSqList(sql1,sql2);
    // 输出归并后的有序表
    printList(sql3);
    return 0;
}