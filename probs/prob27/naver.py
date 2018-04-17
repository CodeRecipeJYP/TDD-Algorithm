def dash_insert(string):
    result = string[0]
    state = int(string[0]) % 2
    for char in string[1:]:
        curr = int(char) % 2
        if state == curr:
            if state == 0:
                result += "+"
            else:
                result += "-"

        result += char
        state = curr
    return result


def main():
    input_string = input()

    dash_inserted_string = dash_insert(input_string)
    print(dash_inserted_string)


if __name__ == "__main__":
    main()
