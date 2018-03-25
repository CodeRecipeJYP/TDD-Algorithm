import unittest

from probs.prob06_gear.gear import roll_gear, str2digit_array


def multiline2states(multiline):
    return [str2digit_array(each_raw_strings)
            for each_raw_strings in multiline.split("\n")]


class RollGearTestCase(unittest.TestCase):
    def test_roll_gear(self):
        gear_raw_strings = """\
10101111
01111101
11001110
00000010
""".rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [3, -1]

        expected_raw_strings = """\
10101111
01111101
10011101
00000001
""".rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_2(self):
        gear_raw_strings = """\
10010011
01010011
11100011
01010101
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [1, 1]

        expected_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_3(self):
        gear_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [2, 1]

        expected_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_4(self):
        gear_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [3, 1]

        expected_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_5(self):
        gear_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [4, 1]

        expected_raw_strings = """\
11001001
10100110
11110001
01010101
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_6(self):
        gear_raw_strings = """\
11001001
10100110
11110001
01010101
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [1, -1]

        expected_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_7(self):
        gear_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [2, -1]

        expected_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_8(self):
        gear_raw_strings = """\
11001001
10100110
11110001
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [3, -1]

        expected_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

    def test_roll_gear_9(self):
        gear_raw_strings = """\
10010011
01010011
11100011
10101010
        """.rstrip()

        gear_states = multiline2states(gear_raw_strings)
        roll_method = [4, -1]

        expected_raw_strings = """\
10010011
01010011
11100011
01010101
        """.rstrip()

        expected_gear_states = multiline2states(expected_raw_strings)

        self.assertEqual(expected_gear_states,
                         roll_gear(gear_states, roll_method))

