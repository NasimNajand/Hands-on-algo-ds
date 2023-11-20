def better_process(matrix, k, x, y, n, m):
    initial_value = matrix[(x // power(n, k - 1)) % n][(y // power(m, k - 1)) % m]

    while k > 1:
        if initial_value == 1:
            initial_value = get_bar_ax(matrix[x % n][y % m])
        else:
            initial_value = matrix[x % n][y % m]

        x //= n
        y //= m
        k -= 1

    return initial_value


def power(base, exponent):
    result = 1
    while exponent > 0:
        result *= base
        exponent -= 1
    return result


def read_matrix(n, m):
    matrix = []
    for i in range(n):
        row = input().strip()
        matrix.append([int(row[j]) for j in range(m)])
    return matrix


def get_bar_ax(input_value):
    return 1 if input_value == 0 else 0


if __name__ == "__main__":
    n, m = map(int, input().split())
    matrix = read_matrix(n, m)

    q = int(input().strip())
    answers = []

    for _ in range(q):
        k, x, y = map(int, input().split())
        answers.append(better_process(matrix, k, x - 1, y - 1, n, m))

    for answer in answers:
        print(answer, end="")
