import unittest

from probs.prob02_algospot_pi.pi import arithmeticSequence, subArithmeticSequence


class ArithmeticSequenceTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(arithmeticSequence('123'), True)

    def test_2(self):
        self.assertEqual(arithmeticSequence('135'), True)

    def test_3(self):
        self.assertEqual(arithmeticSequence('147'), True)

    def test_4(self):
        self.assertEqual(arithmeticSequence('159'), True)

    def test_5(self):
        self.assertEqual(arithmeticSequence('048'), True)

    def test_6(self):
        self.assertEqual(arithmeticSequence('050'), False)

    def test_7(self):
        self.assertEqual(arithmeticSequence('1234'), True)

    def test_8(self):
        self.assertEqual(arithmeticSequence('12345'), True)

    def test_9(self):
        self.assertEqual(arithmeticSequence('13579'), True)


    def test_sub_1(self):
        self.assertEqual(subArithmeticSequence('1123', 3), True)

    def test_sub_2(self):
        self.assertEqual(subArithmeticSequence('11234', 4), True)

    def test_sub_3(self):
        self.assertEqual(subArithmeticSequence('113579', 5), True)

    def test_sub_4(self):
        self.assertEqual(subArithmeticSequence('1135', 3), True)

    def test_sub_5(self):
        self.assertEqual(subArithmeticSequence('1147', 3), True)

    def test_sub_6(self):
        self.assertEqual(subArithmeticSequence('1159', 3), True)

    def test_sub_7(self):
        self.assertEqual(subArithmeticSequence('1048', 3), True)

    def test_sub_8(self):
        self.assertEqual(subArithmeticSequence('1050', 3), False)
