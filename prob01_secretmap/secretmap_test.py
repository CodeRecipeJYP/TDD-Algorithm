import unittest
from prob01_secretmap.secretmap import *




class TestSecretmap(unittest.TestCase):
    """
    Test that the result sum of all numbers
    """
    def test_plus(self):
        result = plus(1, 3)
        self.assertEqual(result, 4)

    def test_integrated_first(self):
        n = 5
        arr1 = [9, 20, 28, 18, 11]
        arr2 = [30, 1, 21, 17, 28]

        result = decode(n, arr1, arr2)

        self.assertEqual(
            result, ["#####","# # #", "### #", "#  ##", "#####"]
        )

    def test_integrated_second(self):
        n = 6
        arr1 = [46, 33, 33 ,22, 31, 50]
        arr2 = [27 ,56, 19, 14, 14, 10]

        result = decode(n, arr1, arr2)

        self.assertEqual(
            result, ["######", "###  #", "##  ##", " #### ", " #####", "### # "]
        )

    def test_encodeSingleline(self):
        decimal = 9
        result = encode_singleline(decimal)
        self.assertEqual(" #  #", result)

        decimal = 20
        result = encode_singleline(decimal)
        self.assertEqual("# #  ", result)

        decimal = 28
        result = encode_singleline(decimal)
        self.assertEqual("###  ", result)

        decimal = 18
        result = encode_singleline(decimal)
        self.assertEqual("#  # ", result)

        decimal = 11
        result = encode_singleline(decimal)
        self.assertEqual(" # ##", result)

        ## -- part2 -- ##
        decimal = 30
        result = encode_singleline(decimal)
        self.assertEqual("#### ", result)

        decimal = 1
        result = encode_singleline(decimal)
        self.assertEqual("    #", result)

        decimal = 21
        result = encode_singleline(decimal)
        self.assertEqual("# # #", result)

        decimal = 17
        result = encode_singleline(decimal)
        self.assertEqual("#   #", result)

        decimal = 28
        result = encode_singleline(decimal)
        self.assertEqual("###  ", result)

    def encode_singleline(self):
        decimal = 46
        result = encode_singleline(decimal, 6)
        self.assertEqual("# ### ", result)

        decimal = 33
        result = encode_singleline(decimal)
        self.assertEqual("#    #", result)

        decimal = 33
        result = encode_singleline(decimal)
        self.assertEqual("#    #", result)

        decimal = 22
        result = encode_singleline(decimal)
        self.assertEqual(" # ## ", result)

        decimal = 31
        result = encode_singleline(decimal)
        self.assertEqual(" #####", result)

        decimal = 50
        result = encode_singleline(decimal)
        self.assertEqual("##  # ", result)

    def test_encodeAll(self):
        decimals = [9, 20, 28, 18, 11]
        result = encode_all(decimals)
        self.assertEqual(
            [
                " #  #",
                "# #  ",
                "###  ",
                "#  # ",
                " # ##",
            ], result)

        decimals = [30, 1, 21, 17, 28]
        result = encode_all(decimals)
        self.assertEqual(
            [
                "#### ",
                "    #",
                "# # #",
                "#   #",
                "###  ",
            ], result)


    def test_decodeWithSingleline(self):
        line1 = " #  #"
        line2 = "#### "
        result = decode_with_singleline(line1, line2)
        self.assertEqual("#####", result)

        line1 = "# #  "
        line2 = "    #"
        result = decode_with_singleline(line1, line2)
        self.assertEqual("# # #", result)

        line1 = "###  "
        line2 = "# # #"
        result = decode_with_singleline(line1, line2)
        self.assertEqual("### #", result)

        line1 = "#  # "
        line2 = "#   #"
        result = decode_with_singleline(line1, line2)
        self.assertEqual("#  ##", result)

        line1 = " # ##"
        line2 = "###  "
        result = decode_with_singleline(line1, line2)
        self.assertEqual("#####", result)