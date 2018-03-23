import unittest

from probs.prob02_algospot_pi.pi import subSimpleIncrease, subSimpleDecrease


class SubSimpleIncreaseTestCase(unittest.TestCase):
    def test_subSimpleIncrease_1(self):
        self.assertEqual(subSimpleIncrease('1123', 3), True)

    def test_subSimpleIncrease_2(self):
        self.assertEqual(subSimpleIncrease('11234', 4), True)

    def test_subSimpleIncrease_3(self):
        self.assertEqual(subSimpleIncrease('112345', 5), True)

    def test_subSimpleIncrease_4(self):
        self.assertEqual(subSimpleIncrease('5234', 3), True)

    def test_subSimpleIncrease_5(self):
        self.assertEqual(subSimpleIncrease('5012', 3), True)

    def test_subSimpleIncrease_6(self):
        self.assertEqual(subSimpleIncrease('1231', 3), False)

    def test_subSimpleIncrease_7(self):
        self.assertEqual(subSimpleIncrease('12341', 5), False)

    def test_subSimpleIncrease_8(self):
        self.assertEqual(subSimpleIncrease('12341', 5), False)


    def test_subSimpleDecrease_1(self):
        self.assertEqual(subSimpleDecrease('1321', 3), True)

    def test_subSimpleDecrease_2(self):
        self.assertEqual(subSimpleDecrease('14321', 4), True)

    def test_subSimpleDecrease_3(self):
        self.assertEqual(subSimpleDecrease('154321', 5), True)

    def test_subSimpleDecrease_4(self):
        self.assertEqual(subSimpleDecrease('1432', 3), True)

    def test_subSimpleDecrease_5(self):
        self.assertEqual(subSimpleDecrease('1210', 3), True)

    def test_subSimpleDecrease_6(self):
        self.assertEqual(subSimpleDecrease('3212', 3), False)

    def test_subSimpleDecrease_7(self):
        self.assertEqual(subSimpleDecrease('3213', 4), False)

    def test_subSimpleDecrease_8(self):
        self.assertEqual(subSimpleDecrease('43214', 5), False)